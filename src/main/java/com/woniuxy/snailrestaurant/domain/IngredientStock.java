package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName ingredient_stock
 */
@Data
public class IngredientStock implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 原料外键
     */
    private Integer ingredianId;

    /**
     * 剩余数量
     */
    private Integer leftCount;

    /**
     * 店铺外键
     */
    private Integer merchantId;

    private static final long serialVersionUID = 1L;
}