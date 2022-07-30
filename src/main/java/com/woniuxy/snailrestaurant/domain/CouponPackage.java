package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @TableId(type = IdType.AUTO)
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
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date pickTime;


    /**
     * 状态,是否领取,是否过期,是否使用
     */
    private Integer status;




    @TableField(exist = false)
    private Coupon coupon;


    private static final long serialVersionUID = 1L;
}
