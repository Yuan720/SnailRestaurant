package com.woniuxy.snailrestaurant.domain.qo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/*
 * 会员信息查询对象
 * */
@Data
public class MemberCardQo {

    @ApiModelProperty(value = "会员Id")
    private Integer memberId;//会员Id

    @ApiModelProperty(value = "门店Id")
    private Integer merchantId;//门店Id

}
