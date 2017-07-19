package com.shop.util.json;


public class AddressJson {
	private int id;

	private String province;
	private String city;
	private String area;
	private String receive_telephone;
	private String receive_user;
	private String minute_address;// œÍœ∏µÿ÷∑
	private UserJson user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getReceive_telephone() {
		return receive_telephone;
	}
	public void setReceive_telephone(String receive_telephone) {
		this.receive_telephone = receive_telephone;
	}
	public String getReceive_user() {
		return receive_user;
	}
	public void setReceive_user(String receive_user) {
		this.receive_user = receive_user;
	}
	public String getMinute_address() {
		return minute_address;
	}
	public void setMinute_address(String minute_address) {
		this.minute_address = minute_address;
	}
	public UserJson getUser() {
		return user;
	}
	public void setUser(UserJson user) {
		this.user = user;
	}
	

	
}
