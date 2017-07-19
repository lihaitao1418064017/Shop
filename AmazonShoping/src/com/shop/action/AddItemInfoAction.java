package com.shop.action;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.service.ItemService;

public class AddItemInfoAction extends AbstractJsonAction {
	private String name;//用户姓名
	private String productName;//产品名称（图片名称)
	private String status;//订单状态
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	protected Object buildJsonObject() throws Exception {
		ItemService.addItem(name, productName, status);
		return null;
	}
	
	
}
