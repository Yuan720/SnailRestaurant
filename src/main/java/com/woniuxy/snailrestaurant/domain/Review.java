package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName review
 */
@Data
public class Review implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 外键,指向菜品
     */
    private Integer dishesId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论日期
     */
    private Date reviewDate;

    /**
     * 用户id, 展示时需要脱敏
     */
    private Integer userId;

    /**
     * 星级
     */
    private Integer star;

    private static final long serialVersionUID = 1L;
}