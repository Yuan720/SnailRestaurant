package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.domain.Dishes;
import com.woniuxy.snailrestaurant.domain.Merchant;
import com.woniuxy.snailrestaurant.domain.User;
import com.woniuxy.snailrestaurant.domain.dto.Images;
import com.woniuxy.snailrestaurant.domain.vo.NearMerchantVo;
import com.woniuxy.snailrestaurant.service.DishesService;
import com.woniuxy.snailrestaurant.service.MerchantService;
import com.woniuxy.snailrestaurant.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MerchantServiceImplTest {
@Autowired
MerchantService service;
    @Test
    void getNearMerchant() {
        Page<NearMerchantVo> nearMerchantVoPage = new Page<>(1,4);
        Page<List<NearMerchantVo>> near = service.getNear(nearMerchantVoPage, "point(113.895197 22.508724)");
        System.out.println("");
    }
}
