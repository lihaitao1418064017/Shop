package com.shop.action;

import java.util.List;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.model.Product;
import com.shop.service.ProductService;
import com.shop.utils.JsonUtil;

public class GetActivityProductAction extends AbstractJsonAction {

	private String isHot;

	public String getIsHot() {
		return isHot;
	}

	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}

	@Override
	protected Object buildJsonObject() throws Exception {
		
		List<Product> list=ProductService.getActivityProduct(isHot);
		return JsonUtil.convertProductList(list);
	}
	
	
}
