package com.shop.action;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.utils.JsonUtil;

public class GetUserInfoAction extends AbstractJsonAction {
	private String user_email;

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	@Override
	protected Object buildJsonObject() throws Exception {
		
		User user = UserService.getUserInfo(user_email);
		return JsonUtil.convertUser(user);
	}

}
