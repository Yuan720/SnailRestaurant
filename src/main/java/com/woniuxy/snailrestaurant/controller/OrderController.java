package com.woniuxy.snailrestaurant.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.woniuxy.snailrestaurant.common.CurrentUser;
import com.woniuxy.snailrestaurant.common.CurrentUserInfo;
import com.woniuxy.snailrestaurant.common.CustomResponse;
import com.woniuxy.snailrestaurant.domain.Order;
import com.woniuxy.snailrestaurant.domain.dto.OrderDTO;
import com.woniuxy.snailrestaurant.mapper.OrderMapper;
import com.woniuxy.snailrestaurant.service.OrderService;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.constraints.NotNull;
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
    CustomResponse creatOrder(@RequestBody @ApiParam(name = "dto", value = "订单信息封装") OrderDTO dto
            , @CurrentUser CurrentUserInfo info) {
        os.createOrder(dto, info);
        return new CustomResponse().setMessage("操作成功").setCode(10000);
    }


    @ApiOperation("订单支付")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "orderNum", value = "订单号码"),
                    @ApiImplicitParam(value = "methodId", name = "支付方式id")
            }
    )
    @PostMapping
    CustomResponse pay(@Param("orderNum") String orderNum, @Valid @NotNull(message = "pay method is needed") Integer methodId)
    {
        return null;
    }


    @ApiOperation(value = "订单支付款")
    @PostMapping("/pay")
    boolean creatOrder(String orderNum,Integer methodId) {
        return os.payOrder(orderNum, methodId);
    }


    @ApiOperation(value = "获取订单信息")
    @GetMapping("/{orderNumber}")
    IPage<Order> getOrderInfo(@PathVariable("orderNumber") @ApiParam(name = "orderNumber", value = "订单号码") String orderNumber) {
        return null;
    }

    @ApiOperation(value = "删除订单信息e")
    @DeleteMapping("/{orderNumber}")
    int deleteOrderInfo(@PathVariable("orderNumber") @ApiParam(name = "orderNumber", value = "订单号码") String orderNumber,
                        @CurrentUser CurrentUserInfo info) {
        Integer userId = info.getId();
        int delete = os.delete(orderNumber, userId);
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
        lqw1.eq(Order::getId, orderNumber);
        Order order = orderMapper.selectOne(lqw1);
        int b = 0;
        if (order.getOrderStatus() == 0) {
            order.setOrderStatus(3);
            b = orderMapper.update(order, lqw);
        }
        return b;

    }

}
