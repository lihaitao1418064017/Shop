package com.shop.action;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.utils.JsonUtil;

public class UpdateUserIdCardAction extends AbstractJsonAction {

	private String user_email;
	private String idCard;
	private String user_name;
	
	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Override
	protected Object buildJsonObject() throws Exception {
		
		User user=UserService.updateUserIdCard(user_email, idCard, user_name);
		return JsonUtil.convertUser(user);
	}
	
}
