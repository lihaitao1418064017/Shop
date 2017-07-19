package com.shop.action;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.service.AddressService;

public class AddUserReceiveAddressAction extends AbstractJsonAction {
	private String phone;
	private String name;
	private String address;
	private String province;
	private String city;
	private String area;
	private String user_email;
	
	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	protected Object buildJsonObject() throws Exception {
		AddressService.addUserReceiveAddress(user_email, province, city, area, phone, name, address);
		return null;
	}

}
