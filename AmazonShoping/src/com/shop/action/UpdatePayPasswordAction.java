package com.shop.action;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.utils.JsonUtil;

public class UpdatePayPasswordAction extends AbstractJsonAction {

	private String user_email;
	private String payPassword;
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	
	@Override
	protected Object buildJsonObject() throws Exception {
		User user=UserService.updatePayPassword(user_email, payPassword);
		return JsonUtil.convertUser(user);
	}
	
}
