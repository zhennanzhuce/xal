package com.xal.ors.biz.impl;

import java.sql.ResultSet;
import java.util.List;

import com.xal.ors.biz.CostItemService;
import com.xal.ors.model.CostItem;
import com.xal.ors.util.ObjectMapper;
import com.xal.ors.util.OptTemplate;

public class CostItemServiceImpl implements CostItemService {
	private OptTemplate optTemplate = null;

	public CostItemServiceImpl(OptTemplate optTemplate) {
		super();
		this.optTemplate = optTemplate;
	}

	@SuppressWarnings("unchecked")
	public List<CostItem> query() {
		String sql = "select * from t_costitem";
		Object[] obj = {};
		return (List<CostItem>) optTemplate.query(sql, obj,
				new CostItemDAOObjectMapper());
	}

	public boolean saveNew(CostItem costItem) {
		String sql = "insert into t_costitem (itemname, daynum, cost,costUnit, comment, comment2) "
				+ "values(?, ?, ?, ?)";
		Object[] obj = { costItem.getItemName(), costItem.getDayNum(),
				costItem.getCost(), costItem.getCostUnit(),
				costItem.getComment(), costItem.getComment2() };
		return optTemplate.update(sql, obj, false);
	}

	public boolean editItem(CostItem costItem) {
		String sql = "update t_costitem set itemname=?, daynum=?, cost=?, costUnit=?, comment=?, comment2=? where id=?";
		Object[] obj = { costItem.getItemName(), costItem.getDayNum(),
				costItem.getCost(), costItem.getCostUnit(),
				costItem.getComment(), costItem.getComment2(), costItem.getId() };
		return optTemplate.update(sql, obj, false);
	}

	public boolean removeItem(Integer id) {
		String sql = "delete from t_costitem where id=?";
		Object[] obj = { id };
		return optTemplate.update(sql, obj, false);
	}

	public boolean removeItem(Integer[] ids) {
		StringBuffer sbStr = new StringBuffer();
		Integer[] obj = ids;
		for (int i = 0; i < ids.length; i++) {
			sbStr.append("?,");
		}
		String sql = "delete from t_costitem where id in("
				+ sbStr.substring(0, sbStr.length() - 1) + ")";
		return optTemplate.update(sql, obj, false);
	}
}

class CostItemDAOObjectMapper implements ObjectMapper {
	public Object mapping(ResultSet rs) {
		CostItem ci = new CostItem();
		try {
			ci.setId(rs.getInt("id"));
			ci.setComment(rs.getString("comment"));
			ci.setCost(rs.getString("cost"));
			ci.setDayNum(rs.getString("dayNum"));
			ci.setItemName(rs.getString("itemName"));
			ci.setCostUnit(rs.getString("costUnit"));
			ci.setComment2(rs.getString("comment2"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ci;
	}
}