package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName order
 */
@Data
public class Order implements Serializable {
    /**
     * 第一位字母标识订单类型
A/B/C/D
第2-7订单日期
220722

8-13位
时间戳后6位
345678
14-18
用户id后5位
19-20
随机2位
45
     */
    private String id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 收餐信息外键
     */
    private Integer deliverInfoId;

    /**
     * 订单状态,已完成/准备中/未支付/已支付/用餐中/已制作
     */
    private Integer orderStatus;

    /**
     * 座位id
     */
    private Integer seatId;

    /**
     * 支付方式
     */
    private String paymentMethod;

    /**
     * 总金额
     */
    private Integer totalCount;

    /**
     * 优惠券
     */
    private Integer couponId;

    /**
     * 商家外键
     */
    private Integer merchantId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 餐具份数,默认1
     */
    private Integer tableware;

    /**
     * 预计送达时间
     */
    private Date expectedTime;

    /**
     * 订单类型,外卖堂食
     */
    private Integer type;

    private static final long serialVersionUID = 1L;
}