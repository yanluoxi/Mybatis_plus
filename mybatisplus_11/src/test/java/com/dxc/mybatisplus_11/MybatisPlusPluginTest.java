package com.dxc.mybatisplus_11;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dxc.mybatisplus_11.mapper.ProductMapper;
import com.dxc.mybatisplus_11.mapper.UserMapper;
import com.dxc.mybatisplus_11.pojo.Product;
import com.dxc.mybatisplus_11.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusPluginTest {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ProductMapper productMapper;
	@Test
	public  void  test(){
		Page<User> page= new Page<>(1,3);
		userMapper.selectPage(page,null);
		System.out.println(page.getRecords());
		System.out.println(page.getPages());
		System.out.println(page.getTotal());
		System.out.println(page.hasNext());
		System.out.println(page.hasPrevious());
	}

	@Test
	public  void  testPageVo(){
		Page<User> page = new Page<>(2, 3);
		userMapper.selectPageVo(page, 20);
		System.out.println(page.getRecords());
		System.out.println(page.getPages());
		System.out.println(page.getTotal());
		System.out.println(page.hasNext());
		System.out.println(page.hasPrevious());
	}

	@Test
	public  void testProduct01(){
		//小李查询商品价格
		Product productLI = productMapper.selectById(1);
		System.out.println("小李查询的商品价格：" + productLI.getPrice());

		//小王查询商品价格
		Product productWang = productMapper.selectById(1);
		System.out.println("小王查询的商品价格：" + productWang.getPrice());

		//小李将商品价格+50
		productLI.setPrice(productLI.getPrice() + 50);
		productMapper.updateById(	productLI);
		//小王将商品价格-30
		productWang.setPrice(productWang.getPrice() - 30);
		int result = productMapper.updateById(productWang);
		if(result == 0 ){
			//操作失败，重试
			Product productNew = productMapper.selectById(1);
			productNew.setPrice(productNew.getPrice() - 30);
			productMapper.updateById(productNew);
		}

		//老板查询商品价格
		Product productLaoban = productMapper.selectById(1);
		System.out.println("老板查询的商品价格：" +productLaoban.getPrice());

	}
}
