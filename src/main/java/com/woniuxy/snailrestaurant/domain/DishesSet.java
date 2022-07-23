package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName dishes_set
 */
@Data
public class DishesSet implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 优惠券外键
     */
    private Integer couponId;

    /**
     * 菜品外键
     */
    private Integer dishesId;

    private static final long serialVersionUID = 1L;
}