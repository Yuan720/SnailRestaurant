package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.domain.DishDetial;
import com.woniuxy.snailrestaurant.domain.Dishes;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "菜品")
@RestController
@RequestMapping("/dishes")
public class DishesController {

    @ApiOperation(value = "返回指定商家的菜品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "merchantId", value = "商家id", required = true),
            @ApiImplicitParam(name = "offset", value = "分页起始值"),
            @ApiImplicitParam(name = "pageSize", value = "分页大小")
    })
    @GetMapping("/{merchantId}")
    List<Dishes> getByMerchantId(@RequestParam(value = "offset", defaultValue = "0", required = false) int offset,
                                 @RequestParam(value = "pageSize", defaultValue = "15", required = false) int pageSize,
                                 @PathVariable("merchantId") int merchantId) {

        return null;
    }


    @ApiOperation(value = "获取菜品详情")
    @GetMapping("/detial/{id}")
    DishDetial getDetial(@PathVariable("id") @ApiParam(name = "id",value = "菜品id")int id) {
        return null;
    }
}
