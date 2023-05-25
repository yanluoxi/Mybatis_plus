package com.dxc.mybatisplus_11.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum SexEnum {

	MALE(1,"男"),
	FEMALE(2,"女");

	@EnumValue
	private Integer sex;
	private String sexName;

	SexEnum(Integer sex, String sexName) {
		this.sex = sex;
		this.sexName = sexName;
	}
}
