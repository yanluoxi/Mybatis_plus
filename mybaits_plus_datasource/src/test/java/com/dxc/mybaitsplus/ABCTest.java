package com.dxc.mybaitsplus;

import com.dxc.mybaitsplus.servcie.ProductService;
import org.junit.jupiter.api.Test;
import com.dxc.mybaitsplus.servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ABCTest {
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;

	@Test
	private void  test(){
		System.out.println(userService.getById(1));
		System.out.println(productService.getById(1));
	}

}
