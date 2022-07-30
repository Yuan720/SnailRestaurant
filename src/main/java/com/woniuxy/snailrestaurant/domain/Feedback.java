package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.woniuxy.snailrestaurant.domain.dto.Images;
import lombok.Data;

/**
 * 反馈表
 * @TableName feedback
 */
@TableName(autoResultMap = true)
@Data
public class Feedback implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer typeId;
    /**
     * 用户外键
     */
    private Integer userId;

    /**
     * 反馈的订单号不是订单主键,是订单号码
     */
    private String orderNumber;

    /**
     * 备注信息
     */
    private String remark;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Images images;

    private static final long serialVersionUID = 1L;
}
