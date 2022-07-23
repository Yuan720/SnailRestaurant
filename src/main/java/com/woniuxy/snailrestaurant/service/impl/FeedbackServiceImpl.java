package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.Feedback;
import com.woniuxy.snailrestaurant.service.FeedbackService;
import com.woniuxy.snailrestaurant.mapper.FeedbackMapper;
import org.springframework.stereotype.Service;

/**
* @author LeeYuan
* @description 针对表【feedback(反馈表)】的数据库操作Service实现
* @createDate 2022-07-23 12:06:44
*/
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback>
    implements FeedbackService{

}




