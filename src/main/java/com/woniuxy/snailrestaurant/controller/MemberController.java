package com.woniuxy.snailrestaurant.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.domain.vo.MemberDetailVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "会员")
@RequestMapping("/member")
@RestController
public class MemberController {

   @ApiOperation("列出会员信息")
    @GetMapping
    Page<MemberDetailVo> listMember(String memberId, String merchantId) {
        return null;

    }
}
