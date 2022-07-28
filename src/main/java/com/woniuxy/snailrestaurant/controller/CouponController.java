package com.woniuxy.snailrestaurant.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.common.CurrentUser;
import com.woniuxy.snailrestaurant.common.CurrentUserInfo;
import com.woniuxy.snailrestaurant.domain.Coupon;
import com.woniuxy.snailrestaurant.domain.CouponPackage;
import com.woniuxy.snailrestaurant.domain.qo.CouponConditionQo;
import com.woniuxy.snailrestaurant.domain.vo.CouponInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Api(tags ="" )
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @ApiOperation(value = "根据条件查找优惠券")
    Page<List<CouponInfoVo>> listCoupons(@CurrentUser CurrentUserInfo info, CouponConditionQo qo){
        return null;
    }


}
