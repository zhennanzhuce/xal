package com.xal.ors.biz;

import java.util.List;

import com.xal.ors.model.CostItem;

public interface CostItemService {
	List<CostItem> query();

	boolean saveNew(CostItem costItem);

	boolean editItem(CostItem costItem);

	boolean removeItem(Integer id);

	boolean removeItem(Integer[] ids);
}
