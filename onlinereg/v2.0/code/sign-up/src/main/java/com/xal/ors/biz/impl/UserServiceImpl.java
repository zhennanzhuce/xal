package com.xal.ors.biz.impl;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

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

	public boolean register(User user) {
		String sql = "insert into s_user (username, userpass, realname, sex, idcard, zzmm, mz, jg, byyx, bysj, xl, zy, gzdw, szbm, cszy, zw, zc, lxdh, lxdz, regtime, costitem, isPass) "
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
		return optTemplate.update(sql, obj, false);
	}

	public List<User> query() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> query(String userName, String idcard) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean editItem(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeItem(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean login(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}

class UserDAOObjectMapper implements ObjectMapper {
	public Object mapping(ResultSet rs) {
		User u = new User();
		try {
			u.setId(rs.getInt("id"));
			u.setBysj(rs.getDate("bysj"));
			u.setByyx(rs.getString("byyx"));
			u.setCszy(rs.getString("cszy"));
			u.setGzdw(rs.getString("gzdw"));
			u.setIdcard(rs.getString("idcard"));
			u.setJg(rs.getString("jg"));
			u.setLxdh(rs.getString("lxdh"));
			u.setLxdz(rs.getString("lxdz"));
			u.setMz(rs.getString("mz"));
			u.setRealName(rs.getString("realName"));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return u;
	}
}
