package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName manual_order
 */
@Data
public class ManualOrder implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 机号
     */
    private String machineId;

    /**
     * 操作人员名字
     */
    private String operator;

    private static final long serialVersionUID = 1L;
}