package com.shop.action;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.utils.JsonUtil;

public class UpdateUserPhoneAction extends AbstractJsonAction {
	private String user_email;
	private String newPhone;
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getNewPhone() {
		return newPhone;
	}
	public void setNewPhone(String newPhone) {
		this.newPhone = newPhone;
	}
	@Override
	protected Object buildJsonObject() throws Exception {
		User user=UserService.updateUserPhone(user_email, newPhone);
		return JsonUtil.convertUser(user);
	}

}
