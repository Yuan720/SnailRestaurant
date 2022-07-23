package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 反馈表
 * @TableName feedback
 */
@Data
public class Feedback implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户外键
     */
    private Integer userId;

    /**
     * 反馈的订单号不是订单主键,是订单号码
     */
    private Integer orderNumber;

    /**
     * 备注信息
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}