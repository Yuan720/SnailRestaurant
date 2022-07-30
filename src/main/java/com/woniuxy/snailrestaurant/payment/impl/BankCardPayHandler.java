package com.woniuxy.snailrestaurant.payment.impl;

import com.woniuxy.snailrestaurant.payment.PaymentHandler;

public class BankCardPayHandler implements PaymentHandler {
    @Override
    public boolean handlePayment(String orderNumber) {
        return false;
    }
}
