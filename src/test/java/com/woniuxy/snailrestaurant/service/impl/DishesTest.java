package com.woniuxy.snailrestaurant.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.snailrestaurant.domain.Dishes;
import com.woniuxy.snailrestaurant.domain.dto.OrderDTO;
import com.woniuxy.snailrestaurant.service.DishesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DishesTest {
    @Autowired
    DishesService service;
    @Autowired
    ObjectMapper mapper;
    @Test
   public void testQuery() {
        List<Integer> integers = Arrays.asList(5, 6, 7, 8);
        QueryWrapper<Dishes> wrapper = new QueryWrapper<>();
        wrapper.in("id", integers);
        List<Dishes> list = service.list(wrapper);
        System.out.println("");
    }

    @Test
    public void jsonTest() throws Exception{
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setTableId(1);
        orderDTO.setCouponId(1);
        orderDTO.setMachineId(1);
        orderDTO.setType(1);
        orderDTO.setTableware(1);
        orderDTO.setRemark("dfghjk");
        orderDTO.setDeliverInfoId(33);
        orderDTO.setOperatorId(567);
        orderDTO.setSeatId(4567);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(2,7654);
        map.put(43,7654);
        map.put(543,7654);
        orderDTO.setDisheInfo(map);
        System.out.println(mapper.writeValueAsString(orderDTO));


    }
}
