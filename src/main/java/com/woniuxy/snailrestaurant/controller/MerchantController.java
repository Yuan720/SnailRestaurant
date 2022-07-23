package com.woniuxy.snailrestaurant.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "商家")
@RestController
@RequestMapping("/merchant")
public class MerchantController {


    @ApiOperation("查询返回附近的商家列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "longitude",value = "经度,由用户设备上报"),
            @ApiImplicitParam(name = "latitude",value = "维度,由用户设备上报")
    })
    @GetMapping("/near")
    List<MerchantController> nearByMerchant(double longitude, double latitude){

        return null;
    }


}
