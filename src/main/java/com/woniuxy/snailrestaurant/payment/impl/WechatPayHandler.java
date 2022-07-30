package com.woniuxy.snailrestaurant.payment.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.woniuxy.snailrestaurant.common.CommonResultCode;
import com.woniuxy.snailrestaurant.domain.Dishes;
import com.woniuxy.snailrestaurant.domain.Order;
import com.woniuxy.snailrestaurant.domain.OrderItem;
import com.woniuxy.snailrestaurant.exception.BusinessException;
import com.woniuxy.snailrestaurant.payment.PaymentHandler;
import com.woniuxy.snailrestaurant.service.DishesService;
import com.woniuxy.snailrestaurant.service.OrderItemService;
import com.woniuxy.snailrestaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.nio.Buffer;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class WechatPayHandler implements PaymentHandler {

    @Autowired
    OrderService orderService;
    @Autowired
    DishesService dishesService;
    @Autowired
    OrderItemService orderItemService;


    @Override
    public boolean handlePayment(String orderNumber) {
        Order order = orderService.getById(orderNumber);
        if (Objects.isNull(order)) {
            throw new BusinessException(CommonResultCode.NO_SUCH_ORDER);
        }
        order.setOrderStatus(1);
        order.setPaymentMethod("微信");
        order.setPrepareStatus("待制作");
        order.setPayTime(new Date());
        QueryWrapper<OrderItem> wrapper = new QueryWrapper<>();
        wrapper.eq("order_number", orderNumber);
        List<OrderItem> list = orderItemService.list(wrapper);
        list.forEach(orderItem -> {
            Integer deshesId = orderItem.getDeshesId();
            int num = orderItem.getItemNum();
            UpdateWrapper<Dishes> dw = new UpdateWrapper<>();
            dw.eq("id", deshesId);
            dw.setSql("total_sales=total_sales+" + num);
            dishesService.update(dw);
        });
        orderService.saveOrUpdate(order);
        return true;
    }
}
