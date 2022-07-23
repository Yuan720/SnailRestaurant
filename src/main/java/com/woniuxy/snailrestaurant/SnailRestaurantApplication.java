package com.woniuxy.snailrestaurant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@MapperScan("com.woniuxy.snailrestaurant.mapper")
@EnableOpenApi
public class SnailRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnailRestaurantApplication.class, args);
	}

}
