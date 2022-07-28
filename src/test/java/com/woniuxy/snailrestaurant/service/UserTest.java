package com.woniuxy.snailrestaurant.service;


import com.woniuxy.snailrestaurant.common.Sha256;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
   void testAddUser(){

        System.out.println(  Sha256.encrypt("123456"));
   }

}
