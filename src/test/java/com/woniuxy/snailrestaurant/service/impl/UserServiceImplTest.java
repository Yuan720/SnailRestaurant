package com.woniuxy.snailrestaurant.service.impl;

import com.woniuxy.snailrestaurant.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserServiceImpl service;
    @Test
   void plusdemon(){
       User byId = service.getById(1);
       System.out.println("");
   }

}
