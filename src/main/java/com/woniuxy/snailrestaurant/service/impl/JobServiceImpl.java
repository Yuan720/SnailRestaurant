package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.Job;
import com.woniuxy.snailrestaurant.service.JobService;
import com.woniuxy.snailrestaurant.mapper.JobMapper;
import org.springframework.stereotype.Service;

/**
* @author LeeYuan
* @description 针对表【job】的数据库操作Service实现
* @createDate 2022-07-25 20:27:40
*/
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job>
    implements JobService{

}




