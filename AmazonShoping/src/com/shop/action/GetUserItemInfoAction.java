package com.shop.action;

import java.util.List;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.model.Item;
import com.shop.model.Product;
import com.shop.service.ItemService;
import com.shop.utils.JsonUtil;

public class GetUserItemInfoAction extends AbstractJsonAction {
	private String name;
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	@Override
	protected Object buildJsonObject() throws Exception {
		List<Product> list=ItemService.getItemInfo(name);
		return JsonUtil.convertProductList(list);
	}
	
}
