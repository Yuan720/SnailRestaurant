package com.woniuxy.snailrestaurant.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithmFactory;
import com.woniuxy.snailrestaurant.common.*;
import com.woniuxy.snailrestaurant.domain.User;
import com.woniuxy.snailrestaurant.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Objects;

@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;
    @Value("${jwt.secretkey}")
    String secretKey;
    @ApiOperation(value = "用户登录,返回jwt令牌")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户账号,密码,json封装", required = true)
    })
    @PostMapping("/login")
    CustomResponse login(@RequestBody User user) {
        CustomResponse customResponse = new CustomResponse();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        String passwd = Sha256.encrypt(user.getHashedPasswd());
        wrapper.eq("user_name", user.getUserName()).and(w -> {
            w.eq("hashed_passwd", passwd);
        });
        User find = service.getOne(wrapper);
        String sign;
        if (Objects.nonNull(find)) {
            long t = System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 3;
            Algorithm alg = Algorithm.HMAC256(secretKey);
            sign = JWT.create()
                    .withClaim("userName", find.getUserName())
                    .withClaim("id",find.getId())
                    .withClaim("accountType","customer")
                    .withIssuedAt(new Date()).withExpiresAt(new Date(t)).sign(alg);
            customResponse.setCode(CommonResultCode.SUCCESS.getCode()).setData(sign).setMessage(CommonResultCode.SUCCESS.getMsg());
        } else {
            sign = "wrong passwd or account not exeist";
            customResponse.setMessage(sign).setCode(CommonResultCode.NO_USER_EXIST_RO_INCORRECT_CREDENTIAL.getCode());
        }

        return customResponse;
    }

    @ApiOperation(value = "用户注册接口")
    @PostMapping("/register")
    boolean register(@RequestBody User user) {
        String userName = user.getUserName();
        String passwd = user.getHashedPasswd();
        assert passwd != null;
        assert userName != null;
        user.setHashedPasswd(Sha256.encrypt(passwd));
        return service.save(user);
    }

    @ApiOperation(value = "更新用户信息")
    @PutMapping
    int updateUser(@RequestBody @ApiParam(name = "user", value = "用户信息") User user) {
        return 0;
    }

}
