package com.dxc.mybatisplus_11.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Product {
	private Long id;
	private String name;
	private Integer price;
	@Version//添加乐观锁版本号字段
	private Integer version;
}
