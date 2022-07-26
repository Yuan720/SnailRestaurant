package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName charge_flow
 */
@Data
public class ChargeFlow implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 钱包外键
     */
    private Integer walletId;

    /**
     * 支付方式
     */
    private Integer paymentMethod;

    /**
     * 充值金额
     */
    private String chargeAmount;

    /**
     * 充值时间
     */
    private Date chargeTime;

    private static final long serialVersionUID = 1L;
}