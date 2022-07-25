package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 卡包
 *
 * @TableName coupon_package
 */
@Data
public class CouponPackage implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 优惠券id
     */

    private Integer couponId;

    /**
     * 张数
     */
    private Integer count;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 领取时间
     */
    private Date pickTime;

    /**
     * 状态,是否领取,是否过期,是否使用
     */
    private String status;

    private static final long serialVersionUID = 1L;
}