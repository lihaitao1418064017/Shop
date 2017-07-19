package com.shop.util.json;

public class ItemJson {
    private int id;//订单编号
 	
	private int userId;//用户id
	private String time;//订单成交时间
	private String status;//订单状态
	private String address;//订单地址
	private String sendCompany;//会计公司
	private String typeStatus;//订单种类
	private int productId;
	private String totalPrice;
	
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getAddress() {
		return address;
	}
	public int getId() {
		return id;
	}
	public String getSendCompany() {
		return sendCompany;
	}
	public String getStatus() {
		return status;
	}
	public String getTime() {
		return time;
	}
	public String getTypeStatus() {
		return typeStatus;
	}
	public int getUserId() {
		return userId;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSendCompany(String sendCompany) {
		this.sendCompany = sendCompany;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setTypeStatus(String typeStatus) {
		this.typeStatus = typeStatus;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
