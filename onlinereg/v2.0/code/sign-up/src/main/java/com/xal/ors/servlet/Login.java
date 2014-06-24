package com.xal.ors.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.xal.ors.ResultMapper;
import com.xal.ors.biz.UserService;
import com.xal.ors.biz.impl.UserServiceImpl;
import com.xal.ors.model.User;
import com.xal.ors.util.OptTemplate;

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

		UserService service = new UserServiceImpl(new OptTemplate());

		User login = service.login(request.getParameter("UserName"),
				request.getParameter("UserPass"));
		ResultMapper mapper = new ResultMapper();
		mapper.setSuccess(null != login);

		Gson gson = new Gson();
		String result = gson.toJson(mapper);

		if (null != login) {
			HttpSession session = request.getSession();
			session.setAttribute("id", login.getId());
			session.setAttribute("user", login);
		}

		out.write(result);
		out.flush();
		out.close();
	}
}
