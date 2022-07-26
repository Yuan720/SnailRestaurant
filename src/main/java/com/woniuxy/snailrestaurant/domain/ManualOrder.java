package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 人工点单生成的订单记录
 * @TableName manual_order
 */
@Data
public class ManualOrder implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 机号
     */
    private String machineId;

    /**
     * 操作人员名字
     */
    private String operator;

    /**
     * 订单外键
     */
    private Integer orderId;

    private static final long serialVersionUID = 1L;
}