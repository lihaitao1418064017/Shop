package com.shop.action;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.model.Product;
import com.shop.service.ProductService;
import com.shop.utils.JsonUtil;

public class GetProductMinuteInfoAction extends AbstractJsonAction {
	private String photo;

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	protected Object buildJsonObject() throws Exception {
		if(photo.contains("#"))
		{
			photo=photo.substring(0, photo.length()-1);
		}
		Product pro=ProductService.getProductMinute(photo);
		return JsonUtil.convertProduct(pro);
	}

}
