package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.LoginLog;
import com.woniuxy.snailrestaurant.service.LoginLogService;
import com.woniuxy.snailrestaurant.mapper.LoginLogMapper;
import org.springframework.stereotype.Service;

/**
* @author LeeYuan
* @description 针对表【login_log】的数据库操作Service实现
* @createDate 2022-07-25 20:27:40
*/
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog>
    implements LoginLogService{

}




