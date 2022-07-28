package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.common.CurrentUser;
import com.woniuxy.snailrestaurant.common.CurrentUserInfo;
import com.woniuxy.snailrestaurant.domain.Order;
import com.woniuxy.snailrestaurant.domain.dto.OrderDTO;
import com.woniuxy.snailrestaurant.domain.qo.OrderSummaryQo;
import com.woniuxy.snailrestaurant.domain.vo.OrderDetailVo;
import com.woniuxy.snailrestaurant.domain.vo.OrderSummaryVo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(tags = "订单")
@RestController
@RequestMapping("/order")
public class OrderController {

    @ApiOperation(value = "创建订单此处未支付,支持线上点餐,到店点餐,服务员人工点餐,返回订单号")
    @PostMapping("/create")
    String creatOrder(@RequestBody @ApiParam(name = "dto", value = "订单信息封装") OrderDTO dto
            , @CurrentUser CurrentUserInfo userInfo) {

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

    @ApiOperation("订单详情")
    @GetMapping("/detail")
    OrderDetailVo getDetail(String orderNum, @CurrentUser CurrentUserInfo info) {
        return null;
    }


    @ApiOperation("查询列表概览")
    @GetMapping("/list")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "qo", value = "查询封装")
    )
    List<OrderSummaryVo> listOrders(OrderSummaryQo qo
            , @CurrentUser CurrentUserInfo info) {
        return null;

    }


}
