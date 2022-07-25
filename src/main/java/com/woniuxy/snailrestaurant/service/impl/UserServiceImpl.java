package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.User;
import com.woniuxy.snailrestaurant.service.UserService;
import com.woniuxy.snailrestaurant.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author LeeYuan
* @description 针对表【user(这是用户表,代表所有注册用户,不包括商家端用户)】的数据库操作Service实现
* @createDate 2022-07-25 20:27:41
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




