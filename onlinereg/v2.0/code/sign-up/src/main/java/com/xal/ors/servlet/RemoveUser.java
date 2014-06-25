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
import com.xal.ors.util.OptTemplate;

public class RemoveUser extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = -3449553758074087715L;

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
		Object id = session.getAttribute("lv");
		if (null == id || 2 != (Integer) id) {
			response.sendRedirect("manage_login.jsp");
			return;
		}

		String ids = request.getParameter("ids");

		UserService service = new UserServiceImpl(new OptTemplate());
		boolean passUser = service.removeItems(ids);

		ResultMapper mapper = new ResultMapper();
		mapper.setSuccess(passUser);

		Gson gson = new Gson();
		String result = gson.toJson(mapper);

		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

}
