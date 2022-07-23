package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 自定义小票模板
 * @TableName custom_invoice_template
 */
@Data
public class CustomInvoiceTemplate implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 商家id 外键
     */
    private Integer merchantId;

    /**
     * 是否打印商家名称
     */
    private Integer dMerchanName;

    /**
     * 是否显示欢迎语
     */
    private Integer dWelcome;

    /**
     * 欢迎文案
     */
    private String welcomeWords;

    /**
     * 是否显示票据类型
     */
    private Integer dInvoceType;

    /**
     * 是否显示桌号
     */
    private Integer dOrderSeat;

    /**
     * 是否显示人数
     */
    private Integer dCoustmerNum;

    /**
     * 是否显示订单编号
     */
    private Integer dOrder;

    /**
     * 是否显示订单时间
     */
    private Integer dOrderTime;

    /**
     * 是否显示菜品详情
     */
    private Integer dDeshesDetail;

    /**
     * 是否显示备注
     */
    private Integer dRemarks;

    /**
     * 是否显示支付详情
     */
    private Integer dPaymentDetail;

    /**
     * 是否显示优惠详情
     */
    private Integer dDiscountInfo;

    /**
     * 是否显示门店地址
     */
    private Integer dAddtionMerchanAddr;

    /**
     * 是否显示门店电话
     */
    private Integer dAddtionMerchanTel;

    /**
     * 是否显示门店微信公众号
     */
    private Integer dAddtionMerchanWchat;

    /**
     * 是否显示门店二维码
     */
    private Integer dAddtionMerchanOrcode;

    /**
     * 是否显示小程序码
     */
    private Integer dAddtionMerchanWeixinProgram;

    /**
     * 是否显示结束语
     */
    private Integer dAddtionTail;

    private static final long serialVersionUID = 1L;
}