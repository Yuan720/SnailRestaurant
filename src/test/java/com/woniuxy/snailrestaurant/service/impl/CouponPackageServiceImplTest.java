package com.woniuxy.snailrestaurant.service.impl;

import com.woniuxy.snailrestaurant.domain.CouponPackage;
import com.woniuxy.snailrestaurant.service.CouponPackageService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CouponPackageServiceImplTest {
@Autowired
    CouponPackageService service;
    @Test
    void findByCondition() {
        CouponPackage byCondition = service.findByCondition(1, 1, 2);
        System.out.println("");
    }
}
