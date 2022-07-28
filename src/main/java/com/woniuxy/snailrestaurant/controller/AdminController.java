package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.common.CurrentUser;
import com.woniuxy.snailrestaurant.common.CurrentUserInfo;
import com.woniuxy.snailrestaurant.domain.MerchantAccount;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;


@Api(tags ="商家端管理")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @ApiOperation("商家端用户登录")
    @PostMapping("/login")
    String login(@RequestBody @ApiParam(name = "account",
            value = "用户登录信息封装") MerchantAccount account)
    {

        return null;
    }

    @ApiOperation("测试")
    @GetMapping("/test")
    @ResponseBody
    CurrentUserInfo test(@CurrentUser CurrentUserInfo info){
        return info;
    }


}
