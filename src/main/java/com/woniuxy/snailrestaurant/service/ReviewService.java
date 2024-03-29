package com.woniuxy.snailrestaurant.service;

import com.woniuxy.snailrestaurant.domain.Review;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.snailrestaurant.domain.dto.ReviewDTO;
import org.springframework.web.multipart.MultipartFile;

/**
* @author LeeYuan
* @description 针对表【review】的数据库操作Service
* @createDate 2022-07-25 20:27:41
*/
public interface ReviewService extends IService<Review> {

    boolean addReview(Review review, MultipartFile[] files);

}
