package com.dxc.mybaitsplus;


import com.dxc.mybaitsplus.servcie.ProductService;
import com.dxc.mybaitsplus.servcie.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybaitsPlusDatasourceApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testDynamicDataSource(){
		System.out.println(userService.getById(1L));
		System.out.println(productService.getById(1L));
	}

}
