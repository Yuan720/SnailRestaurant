package com.woniuxy.snailrestaurant;

import com.woniuxy.snailrestaurant.domain.User;
import com.woniuxy.snailrestaurant.mapper.UserMapper;
import com.woniuxy.snailrestaurant.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class SnailRestaurantApplicationTests {

	@Resource
	private UserService user;
	@Test
	void contextLoads() {

	}

}
