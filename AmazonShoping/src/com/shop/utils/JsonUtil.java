package com.shop.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.model.Address;
import com.shop.model.Item;
import com.shop.model.Product;
import com.shop.model.User;
import com.shop.util.json.AddressJson;
import com.shop.util.json.ItemJson;
import com.shop.util.json.ProductJson;
import com.shop.util.json.UserJson;

public class JsonUtil {
	// 将员工信息json化
	public static UserJson convertUser(User user) {
		if (null == user)
			return null;
		UserJson json = new UserJson();
		json.setUser_sex(ConvertUtil.convertString(user.getUser_sex()));
		json.setUser_Id(user.getUser_id());
		json.setActive_code(ConvertUtil.convertString(user.getActive_code()));
		json.setPayPassword(ConvertUtil.convertString(user.getPayPassword()));
		json.setActive_status(ConvertUtil.convertString(user.getActive_status()));
		json.setUser_email(ConvertUtil.convertString(user.getUser_email()));
		json.setUser_petName(ConvertUtil.convertString(user.getUser_petName()));
		json.setUser_pirthday(ConvertUtil.convertDateToYYYYMMDD(user
				.getUser_pirthday()));
		json.setUser_name(ConvertUtil.convertString(user.getUser_name()));
		json.setUser_telephone(ConvertUtil.convertString(user
				.getUser_telephone()));
		json.setUser_password(ConvertUtil.convertString(user.getUser_password()));
		json.setIdCard(ConvertUtil.convertString(user.getIdCard()));
		System.out.println("转换EmployeeJson完成！");
		return json;
	}

	// 将订单信息json化
	public static ItemJson convertItem(Item item) {
		if (null == item)
			return null;
		ItemJson json = new ItemJson();
		json.setAddress(ConvertUtil.convertString(item.getAddress()));
		json.setId(item.getId());
		json.setSendCompany(ConvertUtil.convertString(item.getSendCompany()));
		json.setStatus(ConvertUtil.convertString(item.getStatus()));
		json.setTime(ConvertUtil.convertString(item.getTime()));
		json.setTypeStatus(ConvertUtil.convertString(item.getTypeStatus()));
		json.setUserId(item.getUserId());
		json.setProductId(item.getProductId());
		json.setTotalPrice(ConvertUtil.convertString(item.getTotalPrice()));
		System.out.println("转换ItemJson完成！");
		return json;
	}

	// 将一组商品信息json化
	public static List<ItemJson> convertItemList(List<Item> list) {
		if (null == list)
			return new ArrayList<ItemJson>();
		List<ItemJson> resultList = new ArrayList<ItemJson>();
		for (Item each : list) {
			resultList.add(convertItem(each));
		}
		return resultList;
	}

	// 将商品信息json
	public static ProductJson convertProduct(Product product) {
		if (null == product)
			return null;
		ProductJson json = new ProductJson();
		json.setId(product.getId());
		json.setDescriptive(ConvertUtil.convertString(product.getDescriptive()));
		json.setIsHot(ConvertUtil.convertString(product.getIsHot()));
		json.setMonthSum(ConvertUtil.convertString(product.getMonthSum()));
		json.setName(ConvertUtil.convertString(product.getName()));
		json.setPack(ConvertUtil.convertString(product.getPack()));
		json.setPhoto(ConvertUtil.convertString(product.getPhoto()));
		json.setPrice(ConvertUtil.convertString(product.getPrice()));
		json.setStatus(ConvertUtil.convertString(product.getStatus()));
		json.setTaste(ConvertUtil.convertString(product.getTaste()));
		json.setType(ConvertUtil.convertString(product.getType()));
		json.setTotalSum(ConvertUtil.convertString(product.getTotalSum()));
		json.setShopTime(ConvertUtil.convertString(product.getShopTime()));

		json.setEatWay(ConvertUtil.convertString(product.getEatWay()));
		json.setEvaluate(product.getEvaluate());
		json.setOldPrice(product.getOldPrice());
		json.setPreferential(ConvertUtil.convertString(product
				.getPreferential()));
		json.setSum(product.getSum());

		return json;
	}

	// 将一组商品信息json化
	public static List<ProductJson> convertProductList(List<Product> list) {
		if (null == list)
			return new ArrayList<ProductJson>();
		List<ProductJson> resultList = new ArrayList<ProductJson>();
		for (Product each : list) {
			resultList.add(convertProduct(each));
		}
		return resultList;
	}

	public static AddressJson convertAddress(Address address) {
		if (null == address)
			return null;
		AddressJson json = new AddressJson();
		json.setId(address.getId());
		json.setProvince(ConvertUtil.convertString(address.getProvince()));
		json.setCity(ConvertUtil.convertString(address.getCity()));
		json.setArea(ConvertUtil.convertString(address.getArea()));
		json.setMinute_address(ConvertUtil.convertString(address
				.getMinute_address()));
		json.setReceive_telephone(ConvertUtil.convertString(address
				.getReceive_telephone()));
		json.setReceive_user(ConvertUtil.convertString(address
				.getReceive_user()));
		json.setUser(convertUser(address.getUser()));
		System.out.println("转换AddressJson完成！");
		return json;
	}

	//
	//
	// public static Set<String> convertEmployeeList(Set<String> set1)
	// {
	// if(null==set1)
	// return new HashSet<String>();
	// Set<String> set=new HashSet<String>();
	// for(String each:set)
	// {
	// set.add(convertEmployee(each));
	// }
	// return resultList;
	// }
	//
	public static List<AddressJson> convertAddressList(List<Address> list) {
		if (null == list)
			return new ArrayList<AddressJson>();
		List<AddressJson> resultList = new ArrayList<AddressJson>();
		for (Address each : list) {
			resultList.add(convertAddress(each));
		}
		return resultList;
	}

	//
	//
	//
	// public static String blankToNull(String str)
	// {
	// if (null == str)
	// return null;
	// str = str.trim();
	// if (str.equals(""))
	// return null;
	// if (str.equals("null"))
	// return null;
	// return str;
	// }
	//
	// 将传入的对象直接Json化，返回字符串
	public static String jsonIt(Object it) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String str = mapper.writeValueAsString(it);
			return str;
		} catch (Exception e) {
			throw new RuntimeException("Json化对象时出错：" + e.getMessage());
		}

	}
	//
	//
	// // 从一个list中选取第start——end编号中的全部元素（编号从1开始）
	// public static <T> List<T> rangeList(List<T> list, int start, int end)
	// {
	// if(null==list)
	// return new ArrayList<T>();
	// List<T> result = new ArrayList<T>();
	// start--;
	// end--;
	// for (int i = start; i <= end; i++)
	// if (i < list.size() && i >= 0)
	// result.add(list.get(i));
	// else
	// break;
	// System.out.println("range list size:" + result.size());
	// return result;
	// }

}
