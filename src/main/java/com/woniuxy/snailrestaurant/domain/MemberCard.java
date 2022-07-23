package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 会员卡
 * @TableName member_card
 */
@Data
public class MemberCard implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 用户外键
     */
    private Integer userId;

    /**
     * 余额
     */
    private BigDecimal balance;

    private static final long serialVersionUID = 1L;
}