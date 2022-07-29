package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.snailrestaurant.domain.Review;
import com.woniuxy.snailrestaurant.domain.dto.Images;
import com.woniuxy.snailrestaurant.domain.dto.ReviewDTO;
import com.woniuxy.snailrestaurant.service.FileService;
import com.woniuxy.snailrestaurant.service.ReviewService;
import com.woniuxy.snailrestaurant.mapper.ReviewMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author LeeYuan
* @description 针对表【review】的数据库操作Service实现
* @createDate 2022-07-25 20:27:41
*/
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review>
    implements ReviewService{

    @Resource
    FileService fileService;
    @Resource
    ObjectMapper mapper;

    @Resource
    ReviewService reviewService;
    @Transactional
    @Override
    public boolean addReview(Review review, MultipartFile[] files) {
        String[] imagesKeys = fileService.saveFile(files);
        review.setReviewDate(new Date());
        Images images = new Images();
        images.setImages(imagesKeys);
        review.setImages(images);
        reviewService.save(review);
        return true;
    }
}




