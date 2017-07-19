package com.shop.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class Main {
public static void main(String[] args) {
//	ArrayList list=new ArrayList();
//	list.add("nihao");
//	list.add("hello");
//	System.out.println(list);
//	
//	Iterator ite= list.iterator();
//	while(ite.hasNext())
//	{
//		System.out.println(ite.next());
//	}
	Map<String,String> map=new HashMap<String,String>();
	map.put("xian", "西安");
	map.put("beijing", "北京");
	
//	System.out.println(map.get("xian"));
//	map.remove("xian");
//	System.out.println(map);
	Iterator<Entry<String, String>> ite=map.entrySet().iterator();
	while(ite.hasNext())
	{
		Map.Entry<String, String> m=ite.next();
		String key=m.getKey();
		String value=m.getValue();
		System.out.println(key+": "+value);
	}
	Iterator<String> ite1=map.keySet().iterator();
	while(ite1.hasNext()){
		System.out.println(ite1.next());
	}
	Iterator<String> ite2=map.values().iterator();
	while(ite2.hasNext()){
		System.out.println(ite2.next());
	}
	
}
}
