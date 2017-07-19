package com.shop.service;

import java.util.List;

import org.junit.Test;

import com.shop.model.Address;

public class AddressServiceTest {

	@Test
	public void test() {
//		AddressService.addUserReceiveAddress("lht", "陕西", "宝鸡市", "岐山", "346346346", "周董", "新区街道");
//		List<Address> list=AddressService.getAllUserAddress("lht");
//		System.out.println(list);
//		AddressService.removeUserReceiveAddress(7);
//		AddressService.updateAddress("danei", "李海涛","123","1");
		
		AddressService.paySuccess("天天快寄", "lht", "23423", "1");
	}

}


