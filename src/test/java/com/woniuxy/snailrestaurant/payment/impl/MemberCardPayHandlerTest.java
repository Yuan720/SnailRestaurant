package com.woniuxy.snailrestaurant.payment.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MemberCardPayHandlerTest {

    @Autowired
    MemberCardPayHandler handler;
    @Test
    void handlePayment() {
        System.out.println("aa");
        handler.handlePayment("A2207305970580000142");
        System.out.println("");
    }
}
