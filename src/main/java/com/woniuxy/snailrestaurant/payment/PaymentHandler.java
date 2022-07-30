package com.woniuxy.snailrestaurant.payment;

import com.woniuxy.snailrestaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public interface PaymentHandler {
    boolean handlePayment(String orderNumber);
}
