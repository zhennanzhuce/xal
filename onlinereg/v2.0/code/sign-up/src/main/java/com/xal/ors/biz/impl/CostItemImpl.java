package com.xal.ors.biz.impl;

import java.sql.ResultSet;
import java.util.List;

import com.xal.ors.biz.CostItemService;
import com.xal.ors.model.CostItem;
import com.xal.ors.util.ObjectMapper;
import com.xal.ors.util.OptTemplate;

public class CostItemImpl implements CostItemService {
	private OptTemplate optTemplate = null;

	public CostItemImpl(OptTemplate optTemplate) {
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ci;
	}
}