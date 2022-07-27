package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.woniuxy.snailrestaurant.domain.dto.Images;
import lombok.Data;

/**
 * 商家,餐厅表
 * @TableName merchant
 */
@Data
public class Merchant implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     * 餐厅名字
     */
    private String name;

    /**
     * 代表餐厅的位置
     */
    private String location;

    /**
     * 状态:开业/关闭
     */
    private String status;

    /**
     *
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Images images;

    private static final long serialVersionUID = 1L;
}
