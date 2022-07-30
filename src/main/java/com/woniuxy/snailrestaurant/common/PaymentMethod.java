package com.woniuxy.snailrestaurant.common;

import lombok.Data;


public enum PaymentMethod {
    WX_PAY(0),ALIPAY(1),CASH_PAY(2),BANKCARD_PAY(3),MEMBER_CARD_PAY(4);

    public int getPaymentMethod() {
        return  paymentMethod;
    }

    private int paymentMethod;
    PaymentMethod(int paymentMethod){
        this.paymentMethod=paymentMethod;
    }


}
