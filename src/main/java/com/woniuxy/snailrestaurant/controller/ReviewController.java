package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.domain.Review;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "评论")
@RestController
@RequestMapping("/review")
public class ReviewController {

    @ApiOperation(value = "根据菜品id查询评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "菜品id",required = true),
            @ApiImplicitParam(name = "offset",value = "分页起始值",required = false),
            @ApiImplicitParam(name = "offset",value = "分页大小",required = false)
    })
    @GetMapping("/dishes/{id}")
    List<Review> listReviewByDishesId(@PathVariable("id") int dishesId,
                                      @RequestParam(value = "offset", defaultValue = "0", required = false) int offSet,
                                      @RequestParam(value = "size", defaultValue = "20", required = false) int pageSize)
    {
        return null;
    }
}
