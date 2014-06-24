package com.xal.ors.biz;

import java.util.List;

import com.xal.ors.ResultMapper;
import com.xal.ors.model.User;

public interface UserService {
	User login(String userName, String password);

	List<User> query();

	List<User> query(String userName, String idcard);

	ResultMapper register(User user);

	boolean editItem(User user);

	boolean removeItem(Integer id);

	boolean passUser(String ids, Integer isPass);

	/**
	 * 监测用户名是否存在
	 *
	 * @param userName
	 * @return
	 */
	User isExist(String userName);

	User findById(String id);

	boolean changePass(User user, String newPass);
}
