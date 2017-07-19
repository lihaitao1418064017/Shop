package com.shop.action;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.service.AddressService;

public class PayItemSuccessAction extends AbstractJsonAction {

	private String address;
	private String user_email;
	private String totalPrice;
	private String typeStatus;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTypeStatus() {
		return typeStatus;
	}

	public void setTypeStatus(String typeStatus) {
		this.typeStatus = typeStatus;
	}

	@Override
	protected Object buildJsonObject() throws Exception {
		System.out.println(address);
		 AddressService.paySuccess(address, user_email, totalPrice, typeStatus);
		return null;
	}

}
