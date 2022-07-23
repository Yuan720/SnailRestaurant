package com.woniuxy.snailrestaurant.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {

    @ApiOperation(value = "用户登录,返回jwt令牌")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user",value = "用户账号,密码,json封装",required = true)
    })
    @PostMapping("/login")
    String login(@RequestBody UserController user) {
        return null;
    }


}
