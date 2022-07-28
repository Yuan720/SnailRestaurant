package com.woniuxy.snailrestaurant.controller;


import com.woniuxy.snailrestaurant.domain.dto.OrderDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/mytest")
public class TestController {
    @GetMapping("/te")
    OrderDTO test() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setMachineId(999);
        orderDTO.setCouponId(6789);
        orderDTO.setSeatId(4567);
        orderDTO.setTableId(45678);
        orderDTO.setDeliverInfoId(45678);
        HashMap<Integer,Integer> dishes=new HashMap<>();
        dishes.put(34567,2);
        dishes.put(678,1);
        dishes.put(2345,3);
        orderDTO.setDisheInfo(dishes);
      return orderDTO;
    }
}
