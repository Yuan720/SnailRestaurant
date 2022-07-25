package com.woniuxy.snailrestaurant.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.domain.DishDetial;
import com.woniuxy.snailrestaurant.domain.Dishes;
import com.woniuxy.snailrestaurant.service.DishDetialService;
import com.woniuxy.snailrestaurant.service.DishesService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "菜品")
@RestController
@RequestMapping("/dishes")
public class DishesController {

    @Resource
    private DishesService ds;

    @Resource
    private DishDetialService dishDetialServiceImpl;

    @ApiOperation(value = "返回指定商家的菜品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "merchantId", value = "商家id", required = true),
            @ApiImplicitParam(name = "offset", value = "分页起始值", required = false),
            @ApiImplicitParam(name = "pageSize", value = "分页大小", required = false)
    })
    @GetMapping("/{merchantId}")
    IPage getByMerchantId(@RequestParam(value = "offset", defaultValue = "0", required = false) int offset,
                                           @RequestParam(value = "pageSize", defaultValue = "15", required = false) int pageSize,
                                           @PathVariable("merchantId") int merchantId) {
        IPage page = new Page(offset,pageSize);
        LambdaQueryWrapper<Dishes> lqw = new LambdaQueryWrapper<Dishes>();
        lqw.eq(Dishes::getMerchantId,merchantId);
        IPage iPage = ds.page(page,lqw);
        return iPage;
    }


    @ApiOperation(value = "获取菜品详情")
    @GetMapping("/detial/{id}")
    DishDetial getDetial(@PathVariable("id") @ApiParam(name = "id",value = "菜品id")int id) {
        LambdaQueryWrapper<DishDetial> lqw = new LambdaQueryWrapper<DishDetial>();
        lqw.eq(DishDetial::getDishesId,id);
        DishDetial dishDetial = dishDetialServiceImpl.getOne(lqw);
        return dishDetial;
    }
}
