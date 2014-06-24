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

public class ChangePass extends HttpServlet {
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
		Object id = session.getAttribute("id");
		if (null == id) {
			response.sendRedirect("index.jsp");
			return;
		}

		User user = new User();
		user.setId((Integer) id);
		user.setUserName(request.getParameter("UserName"));
		user.setUserPass(request.getParameter("OldPass"));

		UserService service = new UserServiceImpl(new OptTemplate());
		boolean changePass = service.changePass(user,
				request.getParameter("UserPass").toString());

		ResultMapper mapper = new ResultMapper();
		mapper.setSuccess(changePass);

		Gson gson = new Gson();
		String result = gson.toJson(mapper);

		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}
}
