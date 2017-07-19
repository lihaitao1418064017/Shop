package com.shop.action;

import java.util.List;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.model.Address;
import com.shop.model.User;
import com.shop.service.AddressService;
import com.shop.service.UserService;
import com.shop.utils.JsonUtil;

public class GetUserReceiveAddressAction extends AbstractJsonAction  {
	private String user_email;

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	@Override
	protected Object buildJsonObject() throws Exception {
		List<Address> list=AddressService.getAllUserAddress(user_email);
		return JsonUtil.convertAddressList(list) ;
	}
}
