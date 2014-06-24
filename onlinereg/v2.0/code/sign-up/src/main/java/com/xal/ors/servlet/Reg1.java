package com.xal.ors.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xal.ors.ResultMapper;
import com.xal.ors.biz.UserService;
import com.xal.ors.biz.impl.UserServiceImpl;
import com.xal.ors.model.User;
import com.xal.ors.util.OptTemplate;

public class Reg1 extends HttpServlet {
	private static final long serialVersionUID = -7242279630539832052L;

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

		User user = new User();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			user.setBysj(sdf.parse(request.getParameter("bysj")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setByyx(request.getParameter("byyx"));
		user.setCostItem(request.getParameter("costItem"));
		user.setCszy(request.getParameter("cszy"));
		user.setGzdw(request.getParameter("gzdw"));
		user.setIdcard(request.getParameter("idcard"));

		user.setJg(request.getParameter("jg"));
		user.setLxdh(request.getParameter("lxdh"));
		user.setLxdz(request.getParameter("lxdz"));
		user.setMz(request.getParameter("mz"));

		user.setRealName(request.getParameter("realName"));
		user.setSex(request.getParameter("sex"));
		user.setSzbm(request.getParameter("szbm"));
		user.setUserName(request.getParameter("userName"));
		user.setUserPass(request.getParameter("userPass"));

		user.setXl(request.getParameter("xl"));
		user.setZc(request.getParameter("zc"));
		user.setZw(request.getParameter("zw"));
		user.setZy(request.getParameter("zy"));
		user.setZzmm(request.getParameter("zzmm"));

		UserService service = new UserServiceImpl(new OptTemplate());
		ResultMapper mapper = service.register(user);

		Gson gson = new Gson();
		String result = gson.toJson(mapper);

		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
