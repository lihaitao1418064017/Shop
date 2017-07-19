package com.shop.model;

public class Address {
	private int id;

	private String province;
	private String city;
	private String area;
	private String receive_telephone;
	private String receive_user;
	private String minute_address;// œÍœ∏µÿ÷∑
	private User user;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id != other.id)
			return false;
		return true;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", province=" + province + ", city="
				+ city + ", area=" + area + ", receive_telephone="
				+ receive_telephone + ", receive_user=" + receive_user
				+ ", minute_address=" + minute_address + ", user=" + user + "]";
	}

	
}
