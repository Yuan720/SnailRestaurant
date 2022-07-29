package com.woniuxy.snailrestaurant.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.common.CurrentUser;
import com.woniuxy.snailrestaurant.common.CurrentUserInfo;
import com.woniuxy.snailrestaurant.domain.DeliverInfo;
import com.woniuxy.snailrestaurant.domain.Dishes;
import com.woniuxy.snailrestaurant.service.DeliverInfoService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Api(tags = "地址信息")
@RestController("/deliverInfo")
public class DeliverInfoController {
    @Resource
    private DeliverInfoService dis;
    @ApiOperation(value = "获取用户收餐信息表")
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true),
            @ApiImplicitParam(name = "offset", value = "分页起始值", required = false),
            @ApiImplicitParam(name = "pageSize", value = "分页大小", required = false)
    })
    IPage getDeliverInfoByUserId(
            @RequestParam(value = "offset", defaultValue = "0", required = false) int offset,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @CurrentUser CurrentUserInfo info) {
        IPage page = new Page(offset,pageSize);
        LambdaQueryWrapper<DeliverInfo> lqw = new LambdaQueryWrapper<DeliverInfo>();
        lqw.eq(DeliverInfo::getUserId,info.getId());
        IPage iPage = dis.page(page,lqw);
        return iPage;
    }

    @ApiOperation(value = "增加用户收餐信息")
    @PostMapping
    int addDeliverInfo( @ApiParam(name = "id", value = "用户id") @CurrentUser CurrentUserInfo info
            , @RequestBody @ApiParam(name = "deliverInfo", value = "收餐信息json") DeliverInfo deliverInfo) {
        return 0;
    }
}
