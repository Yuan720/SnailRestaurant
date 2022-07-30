package com.woniuxy.snailrestaurant.payment.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.woniuxy.snailrestaurant.common.CommonResultCode;
import com.woniuxy.snailrestaurant.domain.CouponPackage;
import com.woniuxy.snailrestaurant.domain.Dishes;
import com.woniuxy.snailrestaurant.domain.Order;
import com.woniuxy.snailrestaurant.domain.OrderItem;
import com.woniuxy.snailrestaurant.exception.BusinessException;
import com.woniuxy.snailrestaurant.payment.PaymentHandler;
import com.woniuxy.snailrestaurant.service.CouponPackageService;
import com.woniuxy.snailrestaurant.service.DishesService;
import com.woniuxy.snailrestaurant.service.OrderItemService;
import com.woniuxy.snailrestaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class AlipayHandler implements PaymentHandler {
    @Autowired
    OrderService orderService;
    @Autowired
    DishesService dishesService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    CouponPackageService couponPackageService;
    @Override
    public boolean handlePayment(String orderNumber) {
        Order order = orderService.getById(orderNumber);
        if (Objects.isNull(order)) {
            throw new BusinessException(CommonResultCode.NO_SUCH_ORDER);
        }
        order.setOrderStatus(1);
        order.setPaymentMethod("支付宝");
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
            //销量累加
            dishesService.update(dw);
        });
        UpdateWrapper<CouponPackage> cpupdateWrapper=new UpdateWrapper<>();
        cpupdateWrapper.eq("id",order.getCouponPackageId());
        cpupdateWrapper.set("status",1);
        //更新订单状态
        orderService.saveOrUpdate(order);
        //更新优惠券状态
        couponPackageService.update(cpupdateWrapper);
        return true;
    }
}
