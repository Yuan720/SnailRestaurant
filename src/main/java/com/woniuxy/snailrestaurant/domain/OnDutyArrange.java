package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName on_duty_arrange
 */
@Data
public class OnDutyArrange implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 外键 指向雇员
     */
    private Integer empId;

    /**
     * 周排班枚举值0 休息 1早班 2 晚班
     */
    private Integer monArrange;

    /**
     * 
     */
    private Integer tueArrange;

    /**
     * 
     */
    private Integer wedArrange;

    /**
     * 
     */
    private Integer thuArrange;

    /**
     * 
     */
    private Integer friArrange;

    /**
     * 
     */
    private Integer satArrange;

    /**
     * 
     */
    private Integer sunArrange;

    private static final long serialVersionUID = 1L;
}