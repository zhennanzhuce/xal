package com.xal.ors.biz;

import java.util.List;

import com.xal.ors.model.User;

public interface UserService {
	boolean login(String userName, String password);

	List<User> query();

	List<User> query(String userName, String idcard);

	boolean register(User user);

	boolean editItem(User user);

	boolean removeItem(Integer id);
}
