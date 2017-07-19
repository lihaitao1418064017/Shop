package com.shop.action;

import java.util.Date;



import com.shop.baseaction.AbstractJsonAction;
import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.utils.ConvertUtil;
import com.shop.utils.JsonUtil;

public class RegisterForShopAction extends AbstractJsonAction {

	private String email;
	private String password;
	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	protected Object buildJsonObject() throws Exception
	{		
		// 输入数据转换
		User registerUser = UserService.register(email, password);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		return JsonUtil.convertUser(registerUser);
	}
}
