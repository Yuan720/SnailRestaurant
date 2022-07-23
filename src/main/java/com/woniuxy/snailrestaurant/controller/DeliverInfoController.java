package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.domain.DeliverInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "地址信息")
@RestController("/deliverInfo")
public class DeliverInfoController {

    @ApiOperation(value = "获取用户收餐信息表")
    @GetMapping("/user/{id}")
    List<DeliverInfo> getDeliverInfoByUserId(@PathVariable("id") @ApiParam(name = "id", value = "用户id") int id) {
        return null;
    }

    @ApiOperation(value = "增加用户收餐信息")
    @PostMapping("/user/{id}")
    int addDeliverInfo(@PathVariable("id") @ApiParam(name = "id", value = "用户id") int id
            , @RequestBody @ApiParam(name = "deliverInfo", value = "收餐信息json") DeliverInfo deliverInfo) {
        return 0;
    }
}
