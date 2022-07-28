package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.domain.Merchant;
import com.woniuxy.snailrestaurant.domain.MerchantAccount;
import com.woniuxy.snailrestaurant.mapper.MerchantMapper;
import com.woniuxy.snailrestaurant.service.MerchantService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "商家")
@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @ApiOperation("查询返回附近的商家列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "longitude", value = "经度,由用户设备上报"),
            @ApiImplicitParam(name = "latitude", value = "维度,由用户设备上报")
    })
    @GetMapping("/near")
    List<MerchantController> nearByMerchant(double longitude, double latitude) {

        return null;
    }

    @ApiOperation("添加商户")
    @PostMapping
    boolean addMerchant(Merchant merchant) {
        return false;
    }

    @ApiOperation("管理和后厨服务端登录")
    @PostMapping("/login")
    String login(@RequestBody @ApiParam(name = "mAccount", value = "登录信息") MerchantAccount mAccount) {
        return null;
    }

}
