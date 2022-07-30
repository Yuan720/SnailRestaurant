package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 优惠券
 * @TableName coupon
 */
@Data
public class Coupon implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 价值
     */
    @TableField("`value`")
    private BigDecimal value;

    /**
     * 最小支付金额
     */
    private BigDecimal minimumPay;

    /**
     * 限制商家
     */
    private Integer limitMerchantId;

    /**
     * 类型 1.全部满减 2.全部打折 3.指定满减 4.指定折扣
     */
    @TableField("`type`")
    private Integer type;

    /**
     * 折扣值 0-100 如80 为八折
     */
    private Integer discount;

    /**
     * 折扣集
     */
    private Integer dishesSetId;

    /**
     * 有效期开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date startTime;

    /**
     * 有效期截至日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date endTime;

    /**
     * 发放数量
     */
    private Integer total;

    /**
     * 领取张数限制
     */
    private Integer limitPer;

    /**
     * 使用场景
     */
    private Integer sceneFor;
    @TableField(exist = false)
    private Coupon coupon;


    /**
     * 剩余数量
     */
    @TableField("`left`")
    private Integer left;

    private static final long serialVersionUID = 1L;
}
