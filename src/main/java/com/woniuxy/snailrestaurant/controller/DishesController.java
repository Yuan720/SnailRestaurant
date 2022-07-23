package com.woniuxy.snailrestaurant.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "菜品")
@RestController
@RequestMapping("/dishes")
public class DishesController {

    @ApiOperation(value = "返回指定商家的菜品列表")
    @GetMapping("/{merchantId}")
    List<DishesController> getByMerchantId(@RequestParam(value = "offset", defaultValue = "0", required = false) int offset,
                                           @RequestParam(value = "pageSize", defaultValue = "15", required = false) int pageSize,
                                           @PathVariable("merchantId") int merchantId) {

        return null;
    }
}
