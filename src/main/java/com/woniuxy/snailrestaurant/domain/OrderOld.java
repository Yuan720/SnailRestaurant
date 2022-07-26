package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName order_old
 */
@Data
public class OrderOld implements Serializable {
    /**
     * 唯一主键
     */
    private Integer id;

    /**
     * 订单号,可以重复,因为有可能每个订单对应多个种类商品
     */
    private String orderNumber;

    /**
     * 用户外键
     */
    private Integer userId;

    /**
     * 菜品外键
     */
    private Integer dishesId;

    /**
     * 当前商品个数
     */
    private Integer numbers;

    /**
     * 到店自助点单/外卖/到店人工点单
     */
    private Integer orderType;

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

    private static final long serialVersionUID = 1L;
}