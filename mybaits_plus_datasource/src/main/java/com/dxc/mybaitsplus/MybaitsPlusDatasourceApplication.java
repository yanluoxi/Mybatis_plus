package com.dxc.mybaitsplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dxc.mybaitsplus.mapper")
public class MybaitsPlusDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybaitsPlusDatasourceApplication.class, args);
	}

}
