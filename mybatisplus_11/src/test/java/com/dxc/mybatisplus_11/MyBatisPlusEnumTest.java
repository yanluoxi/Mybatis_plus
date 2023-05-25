package com.dxc.mybatisplus_11;

import com.dxc.mybatisplus_11.enums.SexEnum;
import com.dxc.mybatisplus_11.mapper.UserMapper;
import com.dxc.mybatisplus_11.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusEnumTest {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void  test(){
		User user = new User();
		user.setName("admin");
		user.setAge(33);
		user.setSex(SexEnum.MALE);
		int insert = userMapper.insert(user);
		System.out.println("result:" + insert );
	}


}
