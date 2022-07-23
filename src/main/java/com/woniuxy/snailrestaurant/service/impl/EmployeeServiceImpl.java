package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.Employee;
import com.woniuxy.snailrestaurant.service.EmployeeService;
import com.woniuxy.snailrestaurant.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

/**
* @author LeeYuan
* @description 针对表【employee】的数据库操作Service实现
* @createDate 2022-07-23 12:06:44
*/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{

}




