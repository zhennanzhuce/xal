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

		if ("".equals(user.getUserName())) {
			String[] msg = { "用户名不能为空", "UserName" };
			mapper.setMsg(msg);
			return mapper;
		}

		if ("".equals(user.getUserPass())) {
			String[] msg = { "密码不能为空", "UserPass" };
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
				+ "zw, zc, lxdh, lxdz, regtime, costitem, isPass) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		user.setRegtime(new Date());
		user.setIsPass(0);

		Object[] obj = { user.getUserName(), user.getUserPass(),
				user.getRealName(), user.getSex(), user.getIdcard(),
				user.getZzmm(), user.getMz(), user.getJg(), user.getByyx(),
				user.getBysj(), user.getXl(), user.getZy(), user.getGzdw(),
				user.getSzbm(), user.getCszy(), user.getZw(), user.getZc(),
				user.getLxdh(), user.getLxdz(), user.getRegtime(),
				user.getCostItem(), user.getIsPass() };
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
	public List<User> query(String userName, String idcard) {
		String sql = "select * from s_user where userName=? or idcard=? order by id desc";
		Object[] obj = { userName, idcard };
		return (List<User>) optTemplate.query(sql, obj,
				new UserDAOObjectMapper());
	}

	public boolean editItem(User user) {
		String sql = "update s_user set username=?, userpass=?, realname=?, sex=?, idcard=?, "
				+ "zzmm=?, mz=?, jg=?, byyx=?, bysj=?, "
				+ "xl=?, zy=?, gzdw=?, szbm=?, cszy=?, "
				+ "zw=?, zc=?, lxdh=?, lxdz=?, costitem=? where id=?";

		Object[] obj = { user.getUserName(), user.getUserPass(),
				user.getRealName(), user.getSex(), user.getIdcard(),
				user.getZzmm(), user.getMz(), user.getJg(), user.getByyx(),
				user.getBysj(), user.getXl(), user.getZy(), user.getGzdw(),
				user.getSzbm(), user.getCszy(), user.getZw(), user.getZc(),
				user.getLxdh(), user.getLxdz(), user.getCostItem() };
		return optTemplate.update(sql, obj, false);
	}

	public boolean removeItem(Integer id) {
		String sql = "delete from s_user where id=?";
		Object[] obj = { id };
		return optTemplate.update(sql, obj, false);
	}

	@SuppressWarnings("unchecked")
	public boolean login(String userName, String password) {
		String sql = "select * from s_user where username=?";
		Object[] obj = { userName };

		List<User> users = (List<User>) optTemplate.query(sql, obj,
				new UserDAOObjectMapper());

		if (null == users || 0 == users.size())
			return false;

		return password.equals(users.get(0).getUserPass());
	}

	public boolean passUser(Integer[] ids) {
		StringBuffer sbStr = new StringBuffer();
		Integer[] obj = ids;
		for (int i = 0; i < ids.length; i++) {
			sbStr.append("?,");
		}
		String sql = "update s_user set isPass=1 where id in ("
				+ sbStr.substring(0, sbStr.length() - 1) + ")";
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}
}
