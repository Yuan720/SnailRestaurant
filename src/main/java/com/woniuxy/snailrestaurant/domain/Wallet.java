package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName wallet
 */
@Data
public class Wallet implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 用户外键
     */
    private Integer userId;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 状态
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}