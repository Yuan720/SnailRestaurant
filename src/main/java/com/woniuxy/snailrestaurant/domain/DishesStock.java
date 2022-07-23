package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName dishes_stock
 */
@Data
public class DishesStock implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 菜品外键
     */
    private Integer dishesId;

    /**
     * 外键商户id 
     */
    private Integer merchantId;

    /**
     * 菜品分类 如炒菜/汤
     */
    private String type;

    /**
     * 单位
     */
    private String unit;

    /**
     * 上次盘点时间
     */
    private Date lastCheckTime;

    /**
     * 库存过低线
     */
    private Integer lowThreshold;

    /**
     * 库存过高线
     */
    private Integer upThreshold;

    /**
     * 剩余数量
     */
    private Integer leftCount;

    private static final long serialVersionUID = 1L;
}