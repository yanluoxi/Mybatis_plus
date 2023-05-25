package com.dxc.mybatisplus_11;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dxc.mybatisplus_11.mapper.UserMapper;
import com.dxc.mybatisplus_11.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusWrapperTest {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void test01(){
		//查询用户名包含a，年龄在20到30之间，邮箱信息不为Null的用户信息
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.like("user_name","a").between("age",20,30).
				isNotNull("email");
		List<User> users = userMapper.selectList(queryWrapper);
		users.forEach(System.out::println);
	}

	@Test
	public void  test02(){
	//	查询用户信息，按照年龄的降序排序，若年龄相同，则按照id 升序排序
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("age").orderByAsc("uid");
		List<User> list = userMapper.selectList(queryWrapper);
		list.forEach(System.out::println);

	}

	@Test
	public  void  test03(){
		// 删除邮箱地址为null的用户信息
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.isNull("email");
		int result = userMapper.delete(queryWrapper);
		System.out.println("result:" + result);
	}

	@Test
	public  void  test04(){
		//将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
		QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
		objectQueryWrapper.gt("age",20).like("user_name","a")
				.or()
				.isNull("email");
		User user = new User();
		user.setName("小明");
		user.setEmail("test@atguigu.com");
		int result = userMapper.update(user, objectQueryWrapper);
		System.out.println("result" + result);

	}

	@Test
	public  void test05(){
		///将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
		//lambda中的条件优先执行
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.like("user_name","a")
				.and(i->i.gt("age",20).or().isNull("email"));
		User user = new User();
		user.setName("小红");
		user.setEmail("test@atguigu.com");
		int result = userMapper.update(user, queryWrapper);
		System.out.println("resutl" + result);
	}

	@Test
	public void  test06(){
		//查询用户的用户名、年龄、邮箱信息
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.select("user_name", "age", "email");
		List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
		maps.forEach(System.out::println);
	}

	@Test
	public  void  test07(){
		//查询id小于等于100的用户信息
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.inSql("uid","select uid from t_user where uid <= 100");
		List<User> list = userMapper.selectList(queryWrapper);
		list.forEach(System.out::println);
	}

	@Test
	public  void  test08(){
		//将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
		updateWrapper.like("user_name","a")
				.and(i->i.gt("age",20).or().isNull("email"));
		updateWrapper.set("user_name","小黑").set("email","abc@atguigu.com");

		int result =userMapper.update(null,updateWrapper);

	}

	@Test
	public  void  test09(){
		String username = "";
		Integer ageBegin = 20;
		Integer ageEnd = 30;
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		if(StringUtils.isNotBlank(username)){
			//isNotBlank 判断某个字符串是否不为空字符串，不为Null,不为空白符
			queryWrapper.like("user_name" , username);

		}
		if (ageBegin !=null){
			queryWrapper.ge("age",ageBegin);
		}if (ageEnd !=null)
		{
			queryWrapper.le("age",ageEnd);
		}
		List<User> list = userMapper.selectList(queryWrapper);
		list.forEach(System.out::println);

	}
	@Test
	public  void  test10(){
		String username = "a";
		Integer ageBegin = null;
		Integer ageEnd = 30;
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.like(StringUtils.isNotBlank(username),"user_name",username)
				.ge(ageBegin!=null,"age",ageBegin)
				.le(ageEnd!=null,"age",ageEnd);
		List<User> list = userMapper.selectList(queryWrapper);
		list.forEach(System.out::println);

	}

	@Test
	public  void  test11(){
		String username = "a";
		Integer ageBegin = null;
		Integer ageEnd = 30;
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.like(StringUtils.isNotBlank(username),User::getName,username)
				.ge(ageBegin!=null,User::getAge,ageBegin)
				.le(ageEnd!=null, User::getAge,ageEnd);
		List<User> list = userMapper.selectList(queryWrapper);
		list.forEach(System.out::println);

	}

	@Test
	public  void  test12(){
		//将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
		LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
		updateWrapper.like(User::getName,"a")
				.and(i->i.gt(User::getAge,20).or().isNull(User::getEmail));
		updateWrapper.set(User::getName,"小黑").set(User::getEmail,"abc@atguigu.com");

		int result =userMapper.update(null,updateWrapper);

	}
}
