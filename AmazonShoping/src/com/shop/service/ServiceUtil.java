package com.shop.service;

public class ServiceUtil
{
	//���ַ���ת����һ����ѯ��
	public static String toQueryString(String str)
	{
		if(null==str)
			return "%%";
		str=str.trim();
		return "%"+str+"%";
	}
}
