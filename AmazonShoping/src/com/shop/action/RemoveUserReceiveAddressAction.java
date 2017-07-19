package com.shop.action;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.service.AddressService;

public class RemoveUserReceiveAddressAction extends AbstractJsonAction {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	protected Object buildJsonObject() throws Exception {
		AddressService.removeUserReceiveAddress(id);
		return null;
	}
	
	
	
}
