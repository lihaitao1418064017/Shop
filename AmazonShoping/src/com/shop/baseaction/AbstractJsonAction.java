package com.shop.baseaction;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.utils.JsonUtil;

public abstract class AbstractJsonAction extends ActionSupport {
	private static final long serialVersionUID = -1686151046949511742L;

	// 数据表
	private Map<String, Object> dataMap = new HashMap<String, Object>();

	// 由子类Action覆盖，负责创建出不同的Json对象，返回json化的数据对象
	protected abstract Object buildJsonObject() throws Exception;

	// 业务对象
	@Override
	public String execute() throws Exception {
		dataMap.clear();// 清除map
		try {
			System.out.println(this.getClass() + "-->");// +
														// JsonUtil.jsonIt(this)
		} catch (Exception e) {

		}
		try {
			Object obj = buildJsonObject();// json化的对象
			dataMap.put("success", true);

			// dataMap.put("message", "");
			dataMap.put("message", null);
			dataMap.put("object", obj);
			System.out.println("成功存储");
			return SUCCESS;
		} catch (Exception e) {
			dataMap.put("success", false);
			dataMap.put("message", e.getMessage());
			// dataMap.put("object", "");
			dataMap.put("object", null);

			return SUCCESS;
		}

	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}
}
