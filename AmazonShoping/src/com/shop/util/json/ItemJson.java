package com.shop.util.json;

public class ItemJson {
    private int id;//�������
 	
	private int userId;//�û�id
	private String time;//�����ɽ�ʱ��
	private String status;//����״̬
	private String address;//������ַ
	private String sendCompany;//��ƹ�˾
	private String typeStatus;//��������
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
