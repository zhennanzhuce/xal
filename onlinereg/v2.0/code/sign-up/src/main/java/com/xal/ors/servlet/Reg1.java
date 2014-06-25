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
			user.setBysj(sdf.parse(request.getParameter("Bysj")));
		} catch (ParseException e) {
			// e.printStackTrace();
			ResultMapper mapper = new ResultMapper();
			String[] msg = { "毕业时间不能为空", "Bysj" };
			mapper.setMsg(msg);

			Gson gson = new Gson();
			String result = gson.toJson(mapper);

			PrintWriter out = response.getWriter();
			out.write(result);
			out.flush();
			out.close();
			return;
		}
		user.setByyx(request.getParameter("Byyx"));
		user.setCostItem(request.getParameter("CostItem"));
		user.setCszy(request.getParameter("Cszy"));
		user.setGzdw(request.getParameter("Gzdw"));
		user.setIdcard(request.getParameter("Idcard"));

		user.setJg(request.getParameter("Jg"));
		user.setLxdh(request.getParameter("Lxdh"));
		user.setLxdz(request.getParameter("Lxdz"));
		user.setMz(request.getParameter("Mz"));

		user.setRealName(request.getParameter("RealName"));
		user.setSex(request.getParameter("Sex"));
		user.setSzbm(request.getParameter("Szbm"));
		user.setUserName(request.getParameter("UserName"));
		user.setUserPass(request.getParameter("UserPass"));

		user.setXl(request.getParameter("Xl"));
		user.setZc(request.getParameter("Zc"));
		user.setZw(request.getParameter("Zw"));
		user.setZy(request.getParameter("Zy"));
		user.setZzmm(request.getParameter("Zzmm"));

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
