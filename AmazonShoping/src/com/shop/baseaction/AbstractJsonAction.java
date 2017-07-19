package com.shop.baseaction;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.utils.JsonUtil;

public abstract class AbstractJsonAction extends ActionSupport {
	private static final long serialVersionUID = -1686151046949511742L;

	// ���ݱ�
	private Map<String, Object> dataMap = new HashMap<String, Object>();

	// ������Action���ǣ����𴴽�����ͬ��Json���󣬷���json�������ݶ���
	protected abstract Object buildJsonObject() throws Exception;

	// ҵ�����
	@Override
	public String execute() throws Exception {
		dataMap.clear();// ���map
		try {
			System.out.println(this.getClass() + "-->");// +
														// JsonUtil.jsonIt(this)
		} catch (Exception e) {

		}
		try {
			Object obj = buildJsonObject();// json���Ķ���
			dataMap.put("success", true);

			// dataMap.put("message", "");
			dataMap.put("message", null);
			dataMap.put("object", obj);
			System.out.println("�ɹ��洢");
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
