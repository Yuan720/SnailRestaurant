package com.woniuxy.snailrestaurant.domain.vo;


import lombok.Data;


/*
 * 会员信息页视图对象
 * */
@Data
public class MemberDetailVo {

    private Integer mcId;//会员号
    private String userName;//会员姓名
    private Integer level;//会员类别
    private Integer userTimes;//消费次数
    private Double totalConsum;//消费金额
    private Double balance;//余额；
    private String mcName;//门店名字
    private String tel;//电话
    private Integer status;//状态


}
