package com.shop.action;

import java.util.List;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.model.Item;
import com.shop.service.ItemService;
import com.shop.utils.JsonUtil;

public class GetItemInfoAction extends AbstractJsonAction {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object buildJsonObject() throws Exception {
		List<Item> list=ItemService.getItemInfos(name);
		return JsonUtil.convertItemList(list);
	}
	

}
