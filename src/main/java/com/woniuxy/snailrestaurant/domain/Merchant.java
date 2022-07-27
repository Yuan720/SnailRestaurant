package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
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
     * 代表餐厅的位置 WTK 坐标系统
     */
    private String location;

    /**
     * 状态:开业/关闭
     */
    private String status;

    private static final long serialVersionUID = 1L;
}
