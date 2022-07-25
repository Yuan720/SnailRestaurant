package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.domain.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {
    @Autowired
    UserService service;
    @ApiOperation(value = "用户登录,返回jwt令牌")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户账号,密码,json封装", required = true)
    })
    @PostMapping("/login")
    String login(@RequestBody User user) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        String passwd = Sha256.encrypt(user.getHashedPasswd());
        wrapper.eq("user_name",user.getUserName()).and(w->{w.eq("hashed_passwd",passwd);});
        User find = service.getOne(wrapper);
        if (Objects.nonNull(find)){

        }
        return null;
    }

    @ApiOperation(value = "用户注册接口")
    @PostMapping("/register")
    boolean register(@RequestBody User user) {
        String userName = user.getUserName();
        String passwd = user.getHashedPasswd();
        Integer accountType = user.getAccountType();
        assert  accountType!=null;
        assert passwd!=null;
        assert userName!=null;
        user.setHashedPasswd(Sha256.encrypt(passwd));
      return   service.save(user);
    }

    @ApiOperation(value = "更新用户信息")
    @PutMapping
    int updateUser(@RequestBody @ApiParam(name ="user",value = "用户信息") User user) {
        return 0;
    }


}
