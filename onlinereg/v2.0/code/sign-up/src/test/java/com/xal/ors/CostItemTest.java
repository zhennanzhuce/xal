package com.xal.ors;

import java.util.List;

import junit.framework.TestCase;

import com.xal.ors.biz.CostItemService;
import com.xal.ors.biz.impl.CostItemServiceImpl;
import com.xal.ors.model.CostItem;
import com.xal.ors.util.OptTemplate;

public class CostItemTest extends TestCase {

	public void testQuery() {
		CostItemService service = new CostItemServiceImpl(new OptTemplate());
		List<CostItem> list = service.query();

		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
