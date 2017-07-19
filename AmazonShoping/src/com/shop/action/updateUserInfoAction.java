package com.shop.action;

import java.util.Date;



import com.shop.baseaction.AbstractJsonAction;
import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.utils.ConvertUtil;
import com.shop.utils.JsonUtil;

public class updateUserInfoAction extends AbstractJsonAction {
	private String user_email;

	private String user_name;
	private String user_petName;
	private String user_telephone;
	private String user_sex;
	private String user_birthday;//格式：2017-3-2-19-20-33
	private String user_new_email;

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
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

	public String getUser_telephone() {
		return user_telephone;
	}

	public void setUser_telephone(String user_telephone) {
		this.user_telephone = user_telephone;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_new_email() {
		return user_new_email;
	}

	public void setUser_new_email(String user_new_email) {
		this.user_new_email = user_new_email;
	}

	public String getUser_birthday() {
		return user_birthday;
	}

	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
	@Override
	protected Object buildJsonObject() throws Exception {
		// 输入数据转换
		Date time = ConvertUtil.convertStringToTime(user_birthday);//注册时间
		System.out.println(time+"时间");
		User user=UserService.update(user_email, user_petName, user_name, user_sex, user_telephone, user_new_email,time);
		return JsonUtil.convertUser(user);

	}


}
