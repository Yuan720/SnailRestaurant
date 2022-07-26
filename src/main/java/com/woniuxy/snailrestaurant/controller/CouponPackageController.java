package com.woniuxy.snailrestaurant.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.woniuxy.snailrestaurant.domain.CouponPackage;
import com.woniuxy.snailrestaurant.service.CouponPackageService;
import com.woniuxy.snailrestaurant.service.CouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags ="用户消费券页面")
@RestController
@RequestMapping("/couponPackage")
public class CouponPackageController {
    @Resource
    private CouponPackageService cps;
    @ApiOperation(value = "返回指定用户的消费券")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true),
            @ApiImplicitParam(name = "offset", value = "分页起始值", required = false),
            @ApiImplicitParam(name = "pageSize", value = "分页大小", required = false),
            @ApiImplicitParam(name = "status", value = "优惠券状态", required = true)
    })
    @GetMapping("/{userId}")
    IPage getByMerchantId(@RequestParam(value = "offset", defaultValue = "0", required = false) int offset,
                          @RequestParam(value = "pageSize", defaultValue = "15", required = false) int pageSize,
                          @PathVariable("userId") int userId,
                          int status){
        return cps.findByUserId(offset, pageSize, userId, status);
    }
}
