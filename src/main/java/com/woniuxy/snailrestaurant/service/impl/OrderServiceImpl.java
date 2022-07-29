package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.Order;
import com.woniuxy.snailrestaurant.domain.OrderItem;
import com.woniuxy.snailrestaurant.mapper.OrderItemMapper;
import com.woniuxy.snailrestaurant.service.OrderService;
import com.woniuxy.snailrestaurant.mapper.OrderMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
* @author LeeYuan
* @description 针对表【order】的数据库操作Service实现
* @createDate 2022-07-26 18:58:33
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Transactional
    @Override
    public int delete(@NotNull(message = "订单号不能为空") String orderNumber,
                      @NotNull(message = "用户ID不能为空") Integer userId) {
        LambdaQueryWrapper<Order> lqw1 = new LambdaQueryWrapper<Order>();
        lqw1.eq(Order::getId,orderNumber);
        lqw1.eq(Order::getUserId,userId);
        int delete = orderMapper.delete(lqw1);
        LambdaQueryWrapper<OrderItem> lqw2 = new LambdaQueryWrapper<OrderItem>();
        lqw2.eq(OrderItem::getOrderNumber,orderNumber);
        orderItemMapper.delete(lqw2);
        return delete;
    }
}




