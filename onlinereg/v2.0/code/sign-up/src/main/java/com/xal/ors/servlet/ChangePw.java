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

public class ChangePw extends HttpServlet {
	private static final long serialVersionUID = -2162770572807336518L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Hello World!");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("application/json");

		HttpSession session = request.getSession();
		Object userName = session.getAttribute("UserName");
		if (null == userName) {
			response.sendRedirect("manage_login.jsp");
			return;
		}

		Manager user = new Manager();
		user.setUserName(userName.toString());
		user.setUserPass(request.getParameter("OldPass"));

		MgrService service = new MgrServiceImpl(new OptTemplate());
		ResultMapper mapper = service.changePw(user,
				request.getParameter("UserPass"));

		Gson gson = new Gson();
		String result = gson.toJson(mapper);

		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}
}
