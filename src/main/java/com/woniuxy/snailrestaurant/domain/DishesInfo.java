package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName dishes_info
 */
@Data
public class DishesInfo implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 菜盘名称
     */
    private String name;

    /**
     * 菜品类型
     */
    private String type;

    /**
     * 单位
     */
    private String unit;

    private static final long serialVersionUID = 1L;
}