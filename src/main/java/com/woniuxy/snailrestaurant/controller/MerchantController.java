package com.woniuxy.snailrestaurant.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.domain.Merchant;
import com.woniuxy.snailrestaurant.domain.MerchantAccount;
import com.woniuxy.snailrestaurant.domain.vo.NearMerchantVo;
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
    @Autowired
    MerchantService service;

    @ApiOperation("查询返回附近的商家列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "longitude", value = "经度,由用户设备上报"),
            @ApiImplicitParam(name = "latitude", value = "维度,由用户设备上报"),
            @ApiImplicitParam(name = "page", value = "起始页"),
            @ApiImplicitParam(name = "size", value = "页大小")
    })
    @GetMapping("/near")
    Page<List<NearMerchantVo>> nearByMerchant(Double longitude, Double latitude
            , @RequestParam(value = "page", required = false, defaultValue = "0") Integer page
            , @RequestParam(value = "size", required = false, defaultValue = "15") Integer size) {
            Page<NearMerchantVo> nearMerchantVoPage = new Page<>(page, size);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("point(");
            stringBuilder.append(longitude);
            stringBuilder.append(" ");
            stringBuilder.append(latitude);
            stringBuilder.append(")");
            String query = stringBuilder.toString();
            Page<List<NearMerchantVo>> near = service.getNear(nearMerchantVoPage, query);
            return near;
    }

    @ApiOperation("添加商户")
    @PostMapping
    boolean addMerchant(@RequestBody Merchant merchant) {

        return false;
    }

    @ApiOperation("管理和后厨服务端登录")
    @PostMapping("/login")
    String login(@RequestBody @ApiParam(name = "mAccount", value = "登录信息") MerchantAccount mAccount) {
        return null;
    }

}
