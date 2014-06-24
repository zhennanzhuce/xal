package com.xal.ors.biz;

import java.util.List;

import com.xal.ors.ResultMapper;
import com.xal.ors.model.User;

public interface UserService {
	boolean login(String userName, String password);

	List<User> query();

	List<User> query(String userName, String idcard);

	ResultMapper register(User user);

	boolean editItem(User user);

	boolean removeItem(Integer id);

	boolean passUser(Integer[] ids);

	/**
	 * 监测用户名是否存在
	 *
	 * @param userName
	 * @return
	 */
	User isExist(String userName);
}
