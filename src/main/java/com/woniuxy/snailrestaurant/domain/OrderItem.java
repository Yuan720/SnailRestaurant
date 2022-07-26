package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName order_item
 */
@Data
public class OrderItem implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 
     */
    private String orderNumber;

    /**
     * 类型,有1.菜品费用,2.打包费,3.配送费
     */
    private Integer type;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 图片
     */
    private String imagekey;

    /**
     * 菜品id
     */
    private Integer deshesId;

    /**
     * 数量
     */
    private Integer itemNum;

    private static final long serialVersionUID = 1L;
}