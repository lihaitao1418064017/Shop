package com.shop.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.baseaction.AbstractJsonAction;
import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.util.json.UserJson;
import com.shop.utils.JsonUtil;

public class LoginForShopAction extends AbstractJsonAction {
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	protected Object buildJsonObject() throws Exception {
		User user=UserService.login(name, password);
	
			return JsonUtil.convertUser(user);
	}
	
}
