package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.domain.DishDetial;
import com.woniuxy.snailrestaurant.domain.Dishes;
import com.woniuxy.snailrestaurant.service.DishesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "菜品")
@RestController
@RequestMapping("/dishes")
public class DishesController {

    @Resource
    private DishesService ds;
    @ApiOperation(value = "返回指定商家的菜品列表")
    @GetMapping("/{merchantId}")
    IPage<Dishes> getByMerchantId(@RequestParam(value = "offset", defaultValue = "0", required = false) int offset,
                                           @RequestParam(value = "pageSize", defaultValue = "15", required = false) int pageSize,
                                           @PathVariable("merchantId") int merchantId) {
        IPage page = new Page(offset,pageSize);
        LambdaQueryWrapper<Dishes> lqw = new LambdaQueryWrapper<Dishes>();
        lqw.eq(Dishes::getMerchantId,merchantId);
        IPage iPage = ds.page(page, lqw);
        return iPage;

        return null;
    }


    @ApiOperation(value = "获取菜品详情")
    @GetMapping("/detial/{id}")
    DishDetial getDetial(@PathVariable("id") @ApiParam(name = "id",value = "菜品id")int id) {
        return null;
    }
}
