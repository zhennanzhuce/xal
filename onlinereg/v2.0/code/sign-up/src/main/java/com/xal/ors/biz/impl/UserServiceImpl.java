package com.xal.ors.biz.impl;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.xal.ors.ResultMapper;
import com.xal.ors.biz.UserService;
import com.xal.ors.model.User;
import com.xal.ors.util.ObjectMapper;
import com.xal.ors.util.OptTemplate;

public class UserServiceImpl implements UserService {
	private OptTemplate optTemplate = null;

	public UserServiceImpl(OptTemplate optTemplate) {
		super();
		this.optTemplate = optTemplate;
	}

	public ResultMapper register(User user) {
		ResultMapper mapper = new ResultMapper();
		mapper.setSuccess(false);

		user.setUserName(user.getUserName().trim());
		if ("".equals(user.getUserName())) {
			String[] msg = { "用户名不能为空", "UserName" };
			mapper.setMsg(msg);
			return mapper;
		}

		if (!user.getUserName().matches("^[a-zA-Z][\\w]{3,15}$")) {
			String[] msg = { "用户名只支持4-16位数字、字母（大小写）或下划线，首字母必须为字母。", "UserName" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setUserPass(user.getUserPass().trim());
		if ("".equals(user.getUserPass())) {
			String[] msg = { "密码不能为空", "UserPass" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setRealName(user.getRealName().trim());
		if ("".equals(user.getRealName())) {
			String[] msg = { "姓名不能为空", "RealName" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setIdcard(user.getIdcard().trim());
		if ("".equals(user.getIdcard())) {
			String[] msg = { "身份证号不能为空", "Idcard" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setByyx(user.getByyx().trim());
		if ("".equals(user.getByyx())) {
			String[] msg = { "毕业院校不能为空", "Byyx" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setZy(user.getZy().trim());
		if ("".equals(user.getZy())) {
			String[] msg = { "专业不能为空", "Zy" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setGzdw(user.getGzdw().trim());
		if ("".equals(user.getGzdw())) {
			String[] msg = { "工作单位不能为空", "Gzdw" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setSzbm(user.getSzbm().trim());
		if ("".equals(user.getSzbm())) {
			String[] msg = { "所在部门不能为空", "Szbm" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setCszy(user.getCszy().trim());
		if ("".equals(user.getCszy())) {
			String[] msg = { "从事专业不能为空", "Cszy" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setZc(user.getZc().trim());
		if ("".equals(user.getZc())) {
			String[] msg = { "职称不能为空", "Zc" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setLxdh(user.getLxdh().trim());
		if ("".equals(user.getLxdh())) {
			String[] msg = { "联系电话不能为空", "Lxdh" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setZgzs(user.getZgzs().trim());
		if ("".equals(user.getZgzs())) {
			String[] msg = { "资格证书不能为空", "Zgzs" };
			mapper.setMsg(msg);
			return mapper;
		}

		User exist = isExist(user.getUserName());
		if (null != exist) {
			String[] msg = { "用户名已经存在", "UserName" };
			mapper.setMsg(msg);
			return mapper;
		}

		String sql = "insert into s_user (username, userpass, realname, sex, idcard, "
				+ "zzmm, mz, jg, byyx, bysj, "
				+ "xl, zy, gzdw, szbm, cszy, "
				+ "zw, zc, lxdh, lxdz, regtime, costitem, isPass, zgzs) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		user.setRegtime(new Date());
		user.setIsPass(0);

		Object[] obj = { user.getUserName(), user.getUserPass(),
				user.getRealName(), user.getSex(), user.getIdcard(),
				user.getZzmm(), user.getMz(), user.getJg(), user.getByyx(),
				user.getBysj(), user.getXl(), user.getZy(), user.getGzdw(),
				user.getSzbm(), user.getCszy(), user.getZw(), user.getZc(),
				user.getLxdh(), user.getLxdz(), user.getRegtime(),
				user.getCostItem(), user.getIsPass(), user.getZgzs() };
		boolean result = optTemplate.update(sql, obj, false);

		if (!result) {
			String[] msg = { "注册失败", "" };
			mapper.setMsg(msg);
		}
		mapper.setSuccess(result);

		return mapper;
	}

	@SuppressWarnings("unchecked")
	public List<User> query() {
		String sql = "select * from s_user order by id desc";
		Object[] obj = {};
		return (List<User>) optTemplate.query(sql, obj,
				new UserDAOObjectMapper());
	}

	@SuppressWarnings("unchecked")
	public List<User> query(String realName, String idcard) {
		String sql = "select * from s_user where ";
		if (!"".equals(realName.trim())) {
			sql += " realname like '%" + realName + "%'";
		}
		if (!"".equals(idcard.trim())) {
			if (!"".equals(realName.trim())) {
				sql += " or ";
			}
			sql += " idcard like '%" + idcard + "%'";
		}
		sql += " order by id desc";

		System.out.println(sql);

		Object[] obj = {};
		return (List<User>) optTemplate.query(sql, obj,
				new UserDAOObjectMapper());
	}

	public ResultMapper editItem(User user) {
		ResultMapper mapper = new ResultMapper();
		mapper.setSuccess(false);

		user.setRealName(user.getRealName().trim());
		if ("".equals(user.getRealName())) {
			String[] msg = { "姓名不能为空", "RealName" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setIdcard(user.getIdcard().trim());
		if ("".equals(user.getIdcard())) {
			String[] msg = { "身份证号不能为空", "Idcard" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setByyx(user.getByyx().trim());
		if ("".equals(user.getByyx())) {
			String[] msg = { "毕业院校不能为空", "Byyx" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setZy(user.getZy().trim());
		if ("".equals(user.getZy())) {
			String[] msg = { "专业不能为空", "Zy" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setGzdw(user.getGzdw().trim());
		if ("".equals(user.getGzdw())) {
			String[] msg = { "工作单位不能为空", "Gzdw" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setSzbm(user.getSzbm().trim());
		if ("".equals(user.getSzbm())) {
			String[] msg = { "所在部门不能为空", "Szbm" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setCszy(user.getCszy().trim());
		if ("".equals(user.getCszy())) {
			String[] msg = { "从事专业不能为空", "Cszy" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setZc(user.getZc().trim());
		if ("".equals(user.getZc())) {
			String[] msg = { "职称不能为空", "Zc" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setLxdh(user.getLxdh().trim());
		if ("".equals(user.getLxdh())) {
			String[] msg = { "联系电话不能为空", "Lxdh" };
			mapper.setMsg(msg);
			return mapper;
		}

		user.setZgzs(user.getZgzs().trim());
		if ("".equals(user.getZgzs())) {
			String[] msg = { "资格证书不能为空", "Zgzs" };
			mapper.setMsg(msg);
			return mapper;
		}

		User user1 = findById(user.getId().toString());
		if (null == user1) {
			String[] msg = { "修改失败", "" };
			mapper.setMsg(msg);
			return mapper;
		}

		if (1 == user1.getIsPass()) {
			String[] msg = { "禁止修改", "" };
			mapper.setMsg(msg);
			return mapper;
		}

		String sql = "update s_user set realname=?, sex=?, idcard=?, "
				+ "zzmm=?, mz=?, jg=?, byyx=?, bysj=?, "
				+ "xl=?, zy=?, gzdw=?, szbm=?, cszy=?, "
				+ "zw=?, zc=?, lxdh=?, lxdz=?, costitem=?, zgzs=? where id=?";

		Object[] obj = { user.getRealName(), user.getSex(), user.getIdcard(),
				user.getZzmm(), user.getMz(), user.getJg(), user.getByyx(),
				user.getBysj(), user.getXl(), user.getZy(), user.getGzdw(),
				user.getSzbm(), user.getCszy(), user.getZw(), user.getZc(),
				user.getLxdh(), user.getLxdz(), user.getCostItem(),
				user.getZgzs(), user.getId() };

		boolean result = optTemplate.update(sql, obj, false);

		if (!result) {
			String[] msg = { "修改失败", "" };
			mapper.setMsg(msg);
		}
		mapper.setSuccess(result);

		return mapper;
	}

	public boolean removeItem(Integer id) {
		String sql = "delete from s_user where id=?";
		Object[] obj = { id };
		return optTemplate.update(sql, obj, false);
	}

	public boolean removeItems(String ids) {
		String sql = "delete from s_user where id in (" + ids + ")";
		Object[] obj = {};
		return optTemplate.update(sql, obj, false);
	}

	@SuppressWarnings("unchecked")
	public User login(String userName, String password) {
		String sql = "select * from s_user where username=?";
		Object[] obj = { userName };

		List<User> users = (List<User>) optTemplate.query(sql, obj,
				new UserDAOObjectMapper());

		if (null == users || 0 == users.size())
			return null;

		User user = users.get(0);

		return password.equals(user.getUserPass()) ? user : null;
	}

	public boolean passUser(String ids, Integer isPass) {
		String sql = "update s_user set isPass=" + isPass + " where id in ("
				+ ids + ")";
		Object[] obj = {};
		return optTemplate.update(sql, obj, false);
	}

	@SuppressWarnings("unchecked")
	public User isExist(String userName) {
		String sql = "select * from s_user where userName=?";
		Object[] obj = { userName };

		List<User> users = (List<User>) optTemplate.query(sql, obj,
				new UserDAOObjectMapper());

		if (null == users) {
			return null;
		}

		return 1 == users.size() ? users.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	public User findById(String id) {
		String sql = "select * from s_user where id=?";
		Object[] obj = { id };

		List<User> users = (List<User>) optTemplate.query(sql, obj,
				new UserDAOObjectMapper());

		if (null == users) {
			return null;
		}

		return 1 == users.size() ? users.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	public User login2(Integer id, String password) {
		String sql = "select * from s_user where id=?";
		Object[] obj = { id };

		List<User> users = (List<User>) optTemplate.query(sql, obj,
				new UserDAOObjectMapper());

		if (null == users || 0 == users.size())
			return null;

		User user = users.get(0);

		return password.equals(user.getUserPass()) ? user : null;
	}

	public boolean changePass(User user, String newPass) {
		User user1 = login2(user.getId(), user.getUserPass());

		if (null == user1)
			return false;

		String sql = "update s_user set userpass=? where id=?";

		Object[] obj = { newPass, user1.getId() };
		return optTemplate.update(sql, obj, false);
	}
}

class UserDAOObjectMapper implements ObjectMapper {
	public Object mapping(ResultSet rs) {
		User user = new User();
		try {
			user.setId(rs.getInt("id"));
			user.setBysj(rs.getDate("bysj"));
			user.setByyx(rs.getString("byyx"));
			user.setCostItem(rs.getString("costItem"));
			user.setCszy(rs.getString("cszy"));

			user.setGzdw(rs.getString("gzdw"));
			user.setIdcard(rs.getString("idcard"));
			user.setJg(rs.getString("jg"));
			user.setLxdh(rs.getString("lxdh"));
			user.setLxdz(rs.getString("lxdz"));

			user.setMz(rs.getString("mz"));
			user.setRealName(rs.getString("realName"));
			user.setRegtime(rs.getDate("regtime"));
			user.setSex(rs.getString("sex"));
			user.setSzbm(rs.getString("szbm"));

			user.setUserName(rs.getString("userName"));
			user.setUserPass(rs.getString("userPass"));
			user.setXl(rs.getString("xl"));
			user.setZc(rs.getString("zc"));
			user.setZw(rs.getString("zw"));

			user.setZy(rs.getString("zy"));
			user.setZzmm(rs.getString("zzmm"));
			user.setIsPass(rs.getInt("isPass"));
			user.setZgzs(rs.getString("zgzs"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}
}
