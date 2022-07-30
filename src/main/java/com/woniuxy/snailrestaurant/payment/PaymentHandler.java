package com.woniuxy.snailrestaurant.payment;

public interface PaymentHandler {
    boolean handlePayment(String orderNumber);
}
