package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.woniuxy.snailrestaurant.domain.dto.Images;
import lombok.Data;

/**
 *
 * @TableName dishes
 */
@Data
@TableName(autoResultMap = true)
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
    private Double price;

    /**
     *
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Images images;

    private static final long serialVersionUID = 1L;
}
