package com.shop.service;

public class ServiceUtil
{
	//将字符串转换成一个查询串
	public static String toQueryString(String str)
	{
		if(null==str)
			return "%%";
		str=str.trim();
		return "%"+str+"%";
	}
}
