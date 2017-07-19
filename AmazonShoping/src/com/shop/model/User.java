package com.shop.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {
	private int user_id;

	private String user_name;

	private String user_petName;

	private String user_sex;

	private Date user_pirthday;
	private String user_telephone;
	private String user_email;
	private String user_password;
	private String active_code;// ¼¤»îÂë
	private String active_status;// ¼¤»î×´Ì¬
	private String payPassword;
	private String idCard;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_petName() {
		return user_petName;
	}

	public void setUser_petName(String user_petName) {
		this.user_petName = user_petName;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public Date getUser_pirthday() {
		return user_pirthday;
	}

	public void setUser_pirthday(Date user_pirthday) {
		this.user_pirthday = user_pirthday;
	}

	public String getUser_telephone() {
		return user_telephone;
	}

	public void setUser_telephone(String user_telephone) {
		this.user_telephone = user_telephone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getActive_code() {
		return active_code;
	}

	public void setActive_code(String active_code) {
		this.active_code = active_code;
	}

	public String getActive_status() {
		return active_status;
	}

	public void setActive_status(String active_status) {
		this.active_status = active_status;
	}

	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name
				+ ", user_petName=" + user_petName + ", user_sex=" + user_sex
				+ "]";
	}

}
