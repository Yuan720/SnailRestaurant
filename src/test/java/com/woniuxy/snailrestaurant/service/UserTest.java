package com.woniuxy.snailrestaurant.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.snailrestaurant.common.Sha256;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class UserTest {

    @Test
   void testAddUser() throws Exception{
        List<String> strings = Arrays.asList("aaaa", "bbbb", "cccc");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(strings));

    }
}
