package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.domain.Merchant;
import com.woniuxy.snailrestaurant.domain.vo.NearMerchantVo;
import com.woniuxy.snailrestaurant.service.MerchantService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MerchantServiceImplTest {
@Autowired
    MerchantService service;
    @Test
    void getNearMerchant() {
        Page<NearMerchantVo> merchantPage = new Page<>(1, 3);
        List<NearMerchantVo> nearMerchant = service.getNearMerchant(merchantPage, "point(113.941819 22.528443)");
        System.out.println();
    }
}
