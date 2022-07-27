package com.woniuxy.snailrestaurant.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.woniuxy.snailrestaurant.domain.DishDetial;
import com.woniuxy.snailrestaurant.domain.OrderItem;
import com.woniuxy.snailrestaurant.domain.dto.OrderDTO;
import com.woniuxy.snailrestaurant.service.OrderItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "订单菜品列表")
@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Resource
    private OrderItemService orderItem;

    /**
     * 有可能打印订单，所以不分页
     * @param orderNumber
     * @return
     */
    @ApiOperation(value = "通过订单号查询订单里的菜品列表")
    @GetMapping("/select")
    List<OrderItem> selectByOrderNumer(@RequestParam @ApiParam(name = "orderNumber",value = "订单号") String orderNumber) {
        List<OrderItem> oi = orderItem.findByOrderNumer(orderNumber);
        return oi;
    }
}
