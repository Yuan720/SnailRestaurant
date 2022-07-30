package com.woniuxy.snailrestaurant.payment;


import com.woniuxy.snailrestaurant.common.PaymentMethod;
import com.woniuxy.snailrestaurant.payment.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentHandlerFactory {
    @Autowired
    private  WechatPayHandler wechatPayHandler;

    @Autowired
    private BankCardPayHandler bankHandler;
    @Autowired
    private CashPayHandler cashPayHandler;
    @Autowired
    private MemberCardPayHandler memberHandler;
    @Autowired
    private  AlipayHandler alipayHandler;

    public  PaymentHandler getInstance(PaymentMethod method) {
        switch (method.getPaymentMethod()) {
            case 0:
                return wechatPayHandler;
            case 1:
                return alipayHandler;
            case 2:
                return cashPayHandler;
            case 3:
                return bankHandler;
            case 4:
                return memberHandler;
            default:
                return null;

        }
    }
}
