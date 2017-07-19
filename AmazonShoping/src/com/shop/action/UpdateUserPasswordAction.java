package com.shop.action;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.utils.ConvertUtil;
import com.shop.utils.JsonUtil;

public class UpdateUserPasswordAction extends AbstractJsonAction {

	private String user_email;
	private String user_old_password;
	private String user_new_password;

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_old_password() {
		return user_old_password;
	}

	public void setUser_old_password(String user_old_password) {
		this.user_old_password = user_old_password;
	}

	public String getUser_new_password() {
		return user_new_password;
	}

	public void setUser_new_password(String user_new_password) {
		this.user_new_password = user_new_password;
	}

	@Override
	protected Object buildJsonObject() throws Exception {
System.out.println(user_email+","+user_new_password+","+user_old_password);
		User user = UserService.updatePassword(user_email, user_old_password,user_new_password);
		System.out.println(user);
		return JsonUtil.convertUser(user);
	}

}
