package com.woniuxy.snailrestaurant.service;

import com.woniuxy.snailrestaurant.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author LeeYuan
* @description 针对表【user(这是用户表,代表所有注册用户,不包括商家端用户)】的数据库操作Service
* @createDate 2022-07-25 20:27:41
*/
public interface UserService extends IService<User> {
    int receiveCoupon(int userId,int couponId);
}
