package com.shop.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;




import com.shop.model.Product;

public class ProductServiceTest {

	@Test
	public void test() {
//		ProductService.addProduct("»ÈÀ·æ˙", "√…≈£≈∆");
//		List<Product> list=ProductService.getHotProduct("is");
//		
//		System.out.println(list);
        List<Product> list=ProductService.getOrderProduct("order");
		System.out.println(list);
		
		
//		Product pro=ProductService.getProductMinute("../images/activity0.jpg");
//		System.out.println(pro);
	}

}
