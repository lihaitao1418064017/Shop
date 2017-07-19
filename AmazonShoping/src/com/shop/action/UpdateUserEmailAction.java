package com.shop.action;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.utils.JsonUtil;

public class UpdateUserEmailAction extends AbstractJsonAction {

	private String user_email;
	private String  user_new_email;
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_new_email() {
		return user_new_email;
	}
	public void setUser_new_email(String user_new_email) {
		this.user_new_email = user_new_email;
	}
	@Override
	protected Object buildJsonObject() throws Exception {
		
		User user=UserService.updateUserEmail(user_email, user_new_email);
		return JsonUtil.convertUser(user);
	}
	
}
