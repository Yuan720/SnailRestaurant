package com.woniuxy.snailrestaurant.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.snailrestaurant.common.*;
import com.woniuxy.snailrestaurant.domain.MerchantAccount;
import com.woniuxy.snailrestaurant.domain.User;
import com.woniuxy.snailrestaurant.service.MerchantAccountService;
import com.woniuxy.snailrestaurant.service.MerchantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Objects;


@Api(tags = "商家端管理")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    MerchantAccountService service;
    @Value("${jwt.secretkey}")
    String secretKey;

    @ApiOperation("商家端用户登录")
    @PostMapping("/login")
    CustomResponse login(@RequestBody @ApiParam(name = "account",
            value = "用户登录信息封装") MerchantAccount account) {
        CustomResponse customResponse = new CustomResponse();
        QueryWrapper<MerchantAccount> wrapper = new QueryWrapper<>();
        String passwd = Sha256.encrypt(account.getHashedPasswd());
        wrapper.eq("user_name", account.getUserName()).and(w -> {
            w.eq("hashed_passwd", passwd);
        });
        MerchantAccount find = service.getOne(wrapper);
        String sign;
        if (Objects.nonNull(find)) {
            long t = System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 3;
            Algorithm alg = Algorithm.HMAC256(secretKey);
            sign = JWT.create()
                    .withClaim("userName", find.getUserName())
                    .withClaim("id", find.getId())
                    .withClaim("accountType","merchant")
                    .withClaim("role", find.getRole())
                    .withIssuedAt(new Date()).withExpiresAt(new Date(t)).sign(alg);
                    customResponse.setCode(CommonResultCode.SUCCESS.getCode()).setData(sign).setMessage(CommonResultCode.SUCCESS.getMsg());
        } else {
            sign = "wrong passwd or account not exeist";
            customResponse.setMessage(sign).setCode(CommonResultCode.NO_USER_EXIST_RO_INCORRECT_CREDENTIAL.getCode());
        }

        return customResponse;
    }

    @ApiOperation("测试")
    @GetMapping("/test")
    @ResponseBody
    CurrentUserInfo test(@CurrentUser CurrentUserInfo info) {
        return info;
    }


}
