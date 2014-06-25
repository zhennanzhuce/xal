package com.xal.ors;

import java.io.FileOutputStream;
import java.util.List;

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

public class CreatExcel {

	private static List<User> getData1() {
		UserService service = new UserServiceImpl(new OptTemplate());
		List<User> list = service.query();
		return list;
	}

	private static List<CostItem> getData2() {
		CostItemService service = new CostItemServiceImpl(new OptTemplate());
		List<CostItem> list = service.query();
		return list;
	}

	public static void main(String[] args) throws Exception {
		create0();
	}

	private static void create0() {

		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		create1(wb);
		create2(wb);

		// 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("E:/user.xls");
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void create1(HSSFWorkbook wb) {

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
		}
	}

	private static void create2(HSSFWorkbook wb) {

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
			cell.setCellValue(stu.getCost());
		}
	}
}