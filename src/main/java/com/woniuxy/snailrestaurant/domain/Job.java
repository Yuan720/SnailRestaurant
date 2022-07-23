package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName job
 */
@Data
public class Job implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 职位表
     */
    private String name;

    private static final long serialVersionUID = 1L;
}