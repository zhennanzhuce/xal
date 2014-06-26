package com.xal.ors;

import java.util.List;

import junit.framework.TestCase;

import com.xal.ors.biz.UserService;
import com.xal.ors.biz.impl.UserServiceImpl;
import com.xal.ors.model.User;
import com.xal.ors.util.OptTemplate;

public class UserTest extends TestCase {

	public void testQuery() {
		UserService service = new UserServiceImpl(new OptTemplate());
		List<User> list = service.query();

		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public void testLogin() {
		UserService service = new UserServiceImpl(new OptTemplate());
		User result = service.login("haha", "1234");
		System.out.println(result);

		System.out.println(("A111".matches("^[a-zA-Z][\\w]{3,15}$")));
	}
}
