package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.domain.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {

    @ApiOperation(value = "用户登录,返回jwt令牌")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户账号,密码,json封装", required = true)
    })
    @PostMapping("/login")
    String login(@RequestBody UserController user) {

        return null;
    }

    @ApiOperation(value = "更新用户信息")
    @PutMapping("/update")
    int updateUser(@RequestBody @ApiParam(name ="user",value = "用户信息") User user) {
        return 0;
    }


}
