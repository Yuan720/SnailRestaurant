package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
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
     * 领取时间
     */
    private Date pickTime;


    /**
     * 状态,是否领取,是否过期,是否使用
     */
    private Integer status;

    @TableField(exist=false)
    private Coupon coupon;

    private static final long serialVersionUID = 1L;
}
