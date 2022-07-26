package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName expend_flow
 */
@Data
public class ExpendFlow implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 商家外键
     */
    private Integer merchantId;

    /**
     * 商家名字
     */
    private String merchantName;

    /**
     * 支出类型,外卖,门店
     */
    private Integer payType;

    /**
     * 消费金额
     */
    private Integer moneyAmount;

    /**
     * 交易时间
     */
    private Date transactionTime;

    private static final long serialVersionUID = 1L;
}