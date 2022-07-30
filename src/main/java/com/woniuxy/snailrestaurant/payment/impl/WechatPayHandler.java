package com.woniuxy.snailrestaurant.payment.impl;

import com.woniuxy.snailrestaurant.payment.PaymentHandler;
public class WechatPayHandler implements PaymentHandler {
    @Override
    public boolean handlePayment(String orderNumber) {
        return false;
    }
}
