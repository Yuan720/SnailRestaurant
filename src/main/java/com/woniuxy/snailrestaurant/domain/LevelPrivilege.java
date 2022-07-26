package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 会员等级特权表
 * @TableName level_privilege
 */
@Data
public class LevelPrivilege implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 会员等级
     */
    private String level;

    /**
     * 折扣值
     */
    private Integer discount;

    /**
     * 礼品标准
     */
    private Integer giftValue;

    /**
     * 消费门槛
     */
    private Integer threshold;

    private static final long serialVersionUID = 1L;
}