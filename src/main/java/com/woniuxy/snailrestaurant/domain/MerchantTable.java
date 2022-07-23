package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName merchant_table
 */
@Data
public class MerchantTable implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 座位数量
     */
    private Integer seatNumbers;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 餐桌类型,冗余字段
     */
    private String type;

    /**
     * 商家外键
     */
    private Integer merchantId;

    private static final long serialVersionUID = 1L;
}