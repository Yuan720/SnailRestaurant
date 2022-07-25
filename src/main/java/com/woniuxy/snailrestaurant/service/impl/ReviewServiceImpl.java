package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.Review;
import com.woniuxy.snailrestaurant.service.ReviewService;
import com.woniuxy.snailrestaurant.mapper.ReviewMapper;
import org.springframework.stereotype.Service;

/**
* @author LeeYuan
* @description 针对表【review】的数据库操作Service实现
* @createDate 2022-07-25 20:27:41
*/
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review>
    implements ReviewService{

}




