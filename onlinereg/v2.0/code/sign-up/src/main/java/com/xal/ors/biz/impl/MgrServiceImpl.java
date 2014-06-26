package com.xal.ors.biz.impl;

import java.sql.ResultSet;
import java.util.List;

import com.xal.ors.ResultMapper;
import com.xal.ors.biz.MgrService;
import com.xal.ors.model.Manager;
import com.xal.ors.util.ObjectMapper;
import com.xal.ors.util.OptTemplate;

public class MgrServiceImpl implements MgrService {
	private OptTemplate optTemplate = null;

	public MgrServiceImpl(OptTemplate optTemplate) {
		super();
		this.optTemplate = optTemplate;
	}

	public ResultMapper changePw(Manager mgr, String newPass) {
		ResultMapper mapper = new ResultMapper();
		Manager user1 = login(mgr.getUserName(), mgr.getUserPass());

		if (null == user1) {
			return mapper;
		}

		String sql = "update s_mgr set userpass=? where username=?";

		Object[] obj = { newPass, mgr.getUserName() };
		boolean result = optTemplate.update(sql, obj, false);

		mapper.setSuccess(result);
		return mapper;
	}

	@SuppressWarnings("unchecked")
	public Manager login(String userName, String password) {
		String sql = "select * from s_mgr where username=?";
		Object[] obj = { userName };

		List<Manager> mgrs = (List<Manager>) optTemplate.query(sql, obj,
				new MgrDAOObjectMapper());

		if (null == mgrs || 0 == mgrs.size())
			return null;

		Manager mgr = mgrs.get(0);

		return password.equals(mgr.getUserPass()) ? mgr : null;
	}
}

class MgrDAOObjectMapper implements ObjectMapper {
	public Object mapping(ResultSet rs) {
		Manager mgr = new Manager();
		try {
			mgr.setUserName(rs.getString("userName"));
			mgr.setUserPass(rs.getString("userPass"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mgr;
	}
}
