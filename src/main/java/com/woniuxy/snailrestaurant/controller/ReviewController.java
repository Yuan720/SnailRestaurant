package com.woniuxy.snailrestaurant.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.domain.Dishes;
import com.woniuxy.snailrestaurant.domain.Review;
import com.woniuxy.snailrestaurant.service.ReviewService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "评论")
@RestController
@RequestMapping("/review")
public class ReviewController {

    @Resource
    private ReviewService review;
    @ApiOperation(value = "根据菜品id查询评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "菜品id",required = true),
            @ApiImplicitParam(name = "offset",value = "分页起始值",required = false),
            @ApiImplicitParam(name = "size",value = "分页大小",required = false)
    })
    @GetMapping("/dishes/{id}")
    IPage listReviewByDishesId(@PathVariable("id") int dishesId,
                                      @RequestParam(value = "offset", defaultValue = "0", required = false) int offSet,
                                      @RequestParam(value = "size", defaultValue = "20", required = false) int pageSize)
    {
        IPage page = new Page(offSet,pageSize);
        LambdaQueryWrapper<Review> lqw = new LambdaQueryWrapper<Review>();
        lqw.eq(Review::getDishesId,dishesId);
        IPage iPage = review.page(page,lqw);
        return iPage;
    }


    @ApiOperation(value = "添加评论")
    @PostMapping
    int addReview(@RequestBody @ApiParam(name = "review",value = "评论内容json请求体") Review review){

        return 0;
    }



}
