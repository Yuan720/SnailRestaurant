package com.woniuxy.snailrestaurant.payment;


import com.woniuxy.snailrestaurant.common.PaymentMethod;
import com.woniuxy.snailrestaurant.payment.impl.*;

public class PaymentHandlerFactory {
    private static PaymentHandler wxHandler = new WechatPayHandler();
    private static PaymentHandler bankHandler = new BankCardPayHandler();
    private static PaymentHandler cashHandler = new CashPayHandler();
    private static PaymentHandler memberHandler = new MemberCardPayHandler();
    private static PaymentHandler alipayHandler = new AlipayHandler();

   public static PaymentHandler getInstance(PaymentMethod method) {
        switch (method.getPaymentMethod()) {
            case 0:
                return wxHandler;
            case 1:
                return alipayHandler;
            case 2:
                return cashHandler;
            case 3:
                return bankHandler;
            case 4:
                return memberHandler;
            default:
                return null;

        }
    }
}
