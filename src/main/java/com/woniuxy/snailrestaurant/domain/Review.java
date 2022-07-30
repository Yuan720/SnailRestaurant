package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.woniuxy.snailrestaurant.domain.dto.Images;
import lombok.Data;


@Data
@TableName(autoResultMap = true)
public class Review implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Images images;

    private static final long serialVersionUID = 1L;
}
