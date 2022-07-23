package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 菜品描述页面
 * @TableName dish_detial
 */
@Data
public class DishDetial implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 外键
     */
    private Integer dishesId;

    /**
     * 菜品描述
     */
    private String dishesDesc;

    private static final long serialVersionUID = 1L;
}