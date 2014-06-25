package com.xal.ors.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.xal.ors.biz.CostItemService;
import com.xal.ors.biz.UserService;
import com.xal.ors.biz.impl.CostItemServiceImpl;
import com.xal.ors.biz.impl.UserServiceImpl;
import com.xal.ors.model.CostItem;
import com.xal.ors.model.User;
import com.xal.ors.util.OptTemplate;

public class ExportExcel extends HttpServlet {

	private static final long serialVersionUID = 8026012484091959303L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Hello World!");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Object id = session.getAttribute("lv");
		if (null == id || 2 != (Integer) id) {
			response.sendRedirect("manage_login.jsp");
			return;
		}

		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		create1(wb);
		create2(wb);

		// 第六步，将文件存到指定位置

		response.reset();
		// 设置response的Header
		response.addHeader("Content-Disposition", "attachment;filename="
				+ new String("user.xls"));
		OutputStream toClient = response.getOutputStream();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");

		wb.write(toClient);
		toClient.close();
		response.flushBuffer();
	}

	private List<User> getData1() {
		UserService service = new UserServiceImpl(new OptTemplate());
		List<User> list = service.query();
		return list;
	}

	private List<CostItem> getData2() {
		CostItemService service = new CostItemServiceImpl(new OptTemplate());
		List<CostItem> list = service.query();
		return list;
	}

	private void create1(HSSFWorkbook wb) {

		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("报名人员");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 创建一个居中格式

		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("编号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("用户名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("姓名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("身份证号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("性别");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("政治面貌");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("民族");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("籍贯");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("毕业院校");
		cell.setCellStyle(style);
		cell = row.createCell((short) 9);
		cell.setCellValue("毕业时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 10);
		cell.setCellValue("学历");
		cell.setCellStyle(style);
		cell = row.createCell((short) 11);
		cell.setCellValue("专业");
		cell.setCellStyle(style);
		cell = row.createCell((short) 12);
		cell.setCellValue("工作单位");
		cell.setCellStyle(style);
		cell = row.createCell((short) 13);
		cell.setCellValue("所在部门");
		cell.setCellStyle(style);
		cell = row.createCell((short) 14);
		cell.setCellValue("从事专业");
		cell.setCellStyle(style);
		cell = row.createCell((short) 15);
		cell.setCellValue("职位");
		cell.setCellStyle(style);
		cell = row.createCell((short) 16);
		cell.setCellValue("职称");
		cell.setCellStyle(style);
		cell = row.createCell((short) 17);
		cell.setCellValue("联系电话");
		cell.setCellStyle(style);
		cell = row.createCell((short) 18);
		cell.setCellValue("联系地址");
		cell.setCellStyle(style);
		cell = row.createCell((short) 19);
		cell.setCellValue("项目编号");
		cell.setCellStyle(style);

		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<User> list = getData1();

		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);
			User stu = list.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell((short) 0).setCellValue((double) stu.getId());
			row.createCell((short) 1).setCellValue(stu.getUserName());
			row.createCell((short) 2).setCellValue(stu.getRealName());
			cell = row.createCell((short) 3);
			cell.setCellValue(stu.getIdcard());
			row.createCell((short) 4).setCellValue(stu.getSex());
			row.createCell((short) 5).setCellValue(stu.getZzmm());
			row.createCell((short) 6).setCellValue(stu.getMz());
			row.createCell((short) 7).setCellValue(stu.getJg());
			row.createCell((short) 8).setCellValue(stu.getByyx());
			row.createCell((short) 9).setCellValue(
					null == stu.getBysj() ? "" : stu.getBysj().toString());
			row.createCell((short) 10).setCellValue(stu.getXl());

			row.createCell((short) 11).setCellValue(stu.getZy());
			row.createCell((short) 12).setCellValue(stu.getGzdw());
			row.createCell((short) 13).setCellValue(stu.getSzbm());
			row.createCell((short) 14).setCellValue(stu.getCszy());
			row.createCell((short) 15).setCellValue(stu.getZw());
			row.createCell((short) 16).setCellValue(stu.getZc());
			row.createCell((short) 17).setCellValue(stu.getLxdh());
			row.createCell((short) 18).setCellValue(stu.getLxdz());
			row.createCell((short) 19).setCellValue(stu.getCostItem());
		}
	}

	private void create2(HSSFWorkbook wb) {

		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("可选项目");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 创建一个居中格式

		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("编号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("项目名称");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("天数");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("费用");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("说明");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("详细");
		cell.setCellStyle(style);

		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<CostItem> list = getData2();

		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);
			CostItem stu = list.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell((short) 0).setCellValue((double) stu.getId());
			row.createCell((short) 1).setCellValue(stu.getItemName());
			row.createCell((short) 2).setCellValue(stu.getDayNum());
			cell = row.createCell((short) 3);
			cell.setCellValue(stu.getCost() + " " + stu.getCostUnit());
			row.createCell((short) 4).setCellValue(stu.getComment());
			row.createCell((short) 5).setCellValue(stu.getComment2());
		}
	}
}
