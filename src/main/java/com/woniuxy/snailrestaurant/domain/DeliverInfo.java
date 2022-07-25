package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName deliver_info
 */
@Data
public class DeliverInfo implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 收餐人名字
     */
    private String recipientName;

    /**
     * 电话
     */
    private String recipientTel;

    /**
     * 收餐人地址
     */
    private String addr;

    /**
     * 布尔值,是否为默认地址
     */
    private Integer asDefault;

    /**
     * 地址标签
     */
    private String tag;

    /**
     * 用户ID（外键）
     */
    private Integer userId;

    private static final long serialVersionUID = 1L;
}
