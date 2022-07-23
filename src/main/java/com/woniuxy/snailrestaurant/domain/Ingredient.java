package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 原料表
 * @TableName ingredient
 */
@Data
public class Ingredient implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 原料名称
     */
    private String name;

    /**
     * 单位
     */
    private String unit;

    /**
     * 类别
     */
    private String type;

    private static final long serialVersionUID = 1L;
}