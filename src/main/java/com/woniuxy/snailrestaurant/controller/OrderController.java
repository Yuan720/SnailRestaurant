package com.woniuxy.snailrestaurant.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.snailrestaurant.common.CommonResultCode;
import com.woniuxy.snailrestaurant.common.CurrentUser;
import com.woniuxy.snailrestaurant.common.CurrentUserInfo;
import com.woniuxy.snailrestaurant.domain.Order;
import com.woniuxy.snailrestaurant.domain.User;
import com.woniuxy.snailrestaurant.domain.dto.OrderDTO;
import com.woniuxy.snailrestaurant.mapper.OrderMapper;
import com.woniuxy.snailrestaurant.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Api(tags = "订单")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService os;
    @Resource
    private OrderMapper orderMapper;

    @ApiOperation(value = "创建订单此处未支付,支持线上点餐,到店点餐,服务员人工点餐,返回订单号")
    @PostMapping("/create")
    String creatOrder(@RequestBody @ApiParam(name = "dto", value = "订单信息封装") OrderDTO dto) {
        return null;
    }


    @ApiOperation(value = "订单支付款")
    @PostMapping("/pay")
    int creatOrder(String orderNum) {
        return 0;
    }


    @ApiOperation(value = "获取订单信息")
    @GetMapping("/{orderNumber}")
    List<Order> getOrderInfo(@PathVariable("orderNumber") @ApiParam(name = "orderNumber", value = "订单号码") String orderNumber) {
        return null;
    }

    @ApiOperation(value = "删除订单信息")
    @DeleteMapping("/{orderNumber}")
    int deleteOrderInfo(@PathVariable("orderNumber") @ApiParam(name = "orderNumber", value = "订单号码") String orderNumber,
                                     @CurrentUser CurrentUserInfo info) {
        Integer userId = info.getId();
        int delete = os.delete(orderNumber,userId);
        return delete;
    }

    @ApiOperation(value = "取消订单")
    @PutMapping("/{orderNumber}")
    int cancelOrder(@PathVariable("orderNumber") @ApiParam(name = "orderNumber", value = "订单号码") String orderNumber
            , @CurrentUser CurrentUserInfo info) {
        LambdaQueryWrapper<Order> lqw = new LambdaQueryWrapper<Order>();
        lqw.eq(Order::getId, orderNumber);
        lqw.eq(Order::getUserId, info.getId());

        LambdaQueryWrapper<Order> lqw1 = new LambdaQueryWrapper<Order>();
        lqw1.eq(Order::getId,orderNumber);
        Order order = orderMapper.selectOne(lqw1);
        int b = 0;
        if (order.getOrderStatus() == 0) {
            order.setOrderStatus(3);
            b = orderMapper.update(order,lqw);

        }
        return b;

    }


}
