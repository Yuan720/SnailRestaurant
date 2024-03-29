package com.woniuxy.snailrestaurant.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.common.CommonResultCode;
import com.woniuxy.snailrestaurant.domain.qo.MemberCardQo;
import com.woniuxy.snailrestaurant.domain.vo.MemberDetailVo;
import com.woniuxy.snailrestaurant.service.MemberCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "会员")
@RequestMapping("/member")
@RestController
public class MemberController {

    @Resource
    private MemberCardService memberCardService;

    @ApiOperation("列出会员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "MemberCardQo", value = "会员查询条件", paramType = "query"),
            @ApiImplicitParam(name = "current", value = "起始页", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "页大小", paramType = "query")
    })

    @GetMapping("/list")
    public Page<MemberDetailVo> listMember(MemberCardQo memberCardQo,
                                           Integer current,
                                           Integer size) {

        return memberCardService.listByCond(memberCardQo, current, size);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除会员信息")
    @ApiImplicitParams({
            //query 表示参数来自于  查询参数
            @ApiImplicitParam(name = "id", value = "会员id", paramType = "path")
    })
    Boolean deleteMember(@PathVariable("id") Integer id) {


        boolean b = memberCardService.removeById(id);

        return b;
    }
}
