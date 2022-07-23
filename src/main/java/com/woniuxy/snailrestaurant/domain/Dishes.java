package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName dishes
 */
@Data
public class Dishes implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 外键,菜品所属的餐厅
     */
    private Integer merchantId;

    /**
     * 菜品名称
     */
    private String name;

    /**
     * 销量
     */
    private Integer totalSales;

    /**
     * 单价
     */
    private BigDecimal price;

    private static final long serialVersionUID = 1L;
}