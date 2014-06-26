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
import com.xal.ors.biz.MgrService;
import com.xal.ors.biz.impl.MgrServiceImpl;
import com.xal.ors.model.Manager;
import com.xal.ors.util.OptTemplate;

public class MLogin extends HttpServlet {

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

		MgrService service = new MgrServiceImpl(new OptTemplate());
		Manager login = service.login(request.getParameter("UserName"),
				request.getParameter("UserPass"));

		ResultMapper mapper = new ResultMapper();
		mapper.setSuccess(login != null);

		Gson gson = new Gson();
		String result = gson.toJson(mapper);

		if (login != null) {
			HttpSession session = request.getSession();
			session.setAttribute("lv", 2);
			session.setAttribute("UserName", login.getUserName());
		}

		out.write(result);
		out.flush();
		out.close();
	}

	public boolean login(String UserName, String UserPass) {
		return ("admin".equals(UserName) && "xal123".equals(UserPass));
	}
}
