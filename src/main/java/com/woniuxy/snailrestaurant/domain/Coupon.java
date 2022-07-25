package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

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
     * 优惠券起始时间
     */
    private Date startTime;

    /**
     * 优惠券过期时间
     */
    private Date endTime;

    /**
     *发放总量
     */
    private Integer total;

    /**
     *每人限领数量
     */
    private Integer limitPer;

    /**
     * 应用场景（1、仅限堂食可用；2、仅限外卖可用；3、堂食外卖均可）
     */
    private Integer sceneFor;

    private static final long serialVersionUID = 1L;
}