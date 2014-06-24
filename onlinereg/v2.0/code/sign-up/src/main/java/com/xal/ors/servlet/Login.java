package com.xal.ors.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xal.ors.ResultMapper;
import com.xal.ors.model.User;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 8026012484091959303L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Hello World!");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("application/json");

		PrintWriter out = response.getWriter();

		User user = new User();
		user.setUserName("haha");

		ResultMapper mapper = new ResultMapper();
		mapper.setData(user);
		mapper.setSuccess(true);

		String[] msg = { "用户名不能为空", "UserName" };
		mapper.setMsg(msg);

		Gson gson = new Gson();
		String result = gson.toJson(mapper);

		out.write(result);
		out.flush();
		out.close();
	}
}
