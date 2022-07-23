package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.domain.Order;
import com.woniuxy.snailrestaurant.domain.dto.OrderDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(tags = "订单")
@RestController
@RequestMapping("/order")
public class OrderController {

    @ApiOperation(value = "点餐,支持线上点餐,到店点餐,服务员人工点餐")
    @PostMapping
    int submitOnlineOrder(@RequestBody @ApiParam(name = "dto",value = "订单信息封装") OrderDTO dto) {
        return 0;
    }

    @ApiOperation(value = "获取订单信息")
    @GetMapping("/{orderNumber}")
    List<Order> getOrderInfo(@PathVariable("orderNumber") @ApiParam(name = "orderNumber",value = "订单号码") String orderNumber){
        return null;
    }



}
