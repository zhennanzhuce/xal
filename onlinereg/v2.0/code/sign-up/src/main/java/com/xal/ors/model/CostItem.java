package com.xal.ors.model;

public class CostItem {
	private Integer id;
	private String itemName;
	private String dayNum;
	private String cost;
	private String comment;

	private String costUnit;
	private String comment2;

	public String getCostUnit() {
		return costUnit;
	}

	public void setCostUnit(String costUnit) {
		this.costUnit = costUnit;
	}

	public String getComment2() {
		return comment2;
	}

	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDayNum() {
		return dayNum;
	}

	public void setDayNum(String dayNum) {
		this.dayNum = dayNum;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
