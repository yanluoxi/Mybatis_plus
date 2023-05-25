package com.dxc.mybatisplus_11.pojo;


import com.baomidou.mybatisplus.annotation.*;
import com.dxc.mybatisplus_11.enums.SexEnum;
import lombok.*;

//如果想添加无参构造，使用Lombok的话，直接在实体类上面加上NoArgsConstructor
@Data
// @TableName("t_user")
public class User {

	//将属性所对应的字段指定为主键
	@TableId(value = "uid")
	private Long id;

	@TableField("user_name")
	private String name;

	private  Integer age;

	private  String email;

	private SexEnum sex;

	@TableLogic
	private  Integer isDeleted;

}
