package com.shop.action;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.service.ItemService;

public class DeleteCloseItemAction extends AbstractJsonAction {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object buildJsonObject() throws Exception {
		ItemService.deleteFailItemInfo(name);
		return null;
	}
	
	
}
