package com.woniuxy.snailrestaurant.payment.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.woniuxy.snailrestaurant.common.CommonResultCode;
import com.woniuxy.snailrestaurant.domain.*;
import com.woniuxy.snailrestaurant.exception.BusinessException;
import com.woniuxy.snailrestaurant.payment.PaymentHandler;
import com.woniuxy.snailrestaurant.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class MemberCardPayHandler implements PaymentHandler {
    @Autowired
    OrderService orderService;
    @Autowired
    DishesService dishesService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    CouponPackageService couponPackageService;

    @Autowired
    WalletService walletService;

    @Override
    public boolean handlePayment(String orderNumber) {
        Order order = orderService.getById(orderNumber);
        if (Objects.isNull(order)) {
            throw new BusinessException(CommonResultCode.NO_SUCH_ORDER);
        }
        order.setOrderStatus(1);
        order.setPaymentMethod("会员卡");
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
        UpdateWrapper<CouponPackage> cpupdateWrapper=new UpdateWrapper<>();
        cpupdateWrapper.eq("id",order.getCouponPackageId());
        cpupdateWrapper.set("status",1);
        QueryWrapper<Wallet> walletQueryWrapper=new QueryWrapper<>();
        walletQueryWrapper.eq("user_id",order.getUserId());
        Wallet one = walletService.getOne(walletQueryWrapper);
        double left=one.getBalance().doubleValue()-order.getTotalCount();
        if (left<0){
        throw new BusinessException(CommonResultCode.INSUFFICIENT_WALLET_BALANCE);
        }else {
           UpdateWrapper<Wallet> updateWrapper=new UpdateWrapper<>();
           updateWrapper.set("balance",BigDecimal.valueOf(left));
           updateWrapper.setSql("use_times=use_times+1");
           updateWrapper.setSql("total_consum=total_consum+"+String.valueOf(order.getTotalCount()));
           walletService.update(updateWrapper);
        }
        //更新订单状态
        orderService.saveOrUpdate(order);
        //更新优惠券状态
        couponPackageService.update(cpupdateWrapper);
        return true;
    }
}
