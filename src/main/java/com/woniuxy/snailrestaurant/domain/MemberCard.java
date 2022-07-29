package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 会员卡7.28 19:14 更新
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

    /**
     * 门店外键,可能关联办卡门店
     */
    private Integer merchantId;

    /**
     * 会员等级
     */
    private Integer level;

    /**
     * 使用次数
     */
    private Integer useTimes;

    /**
     * 总消费额
     */
    private Integer totalConsum;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 电话
     */
    private String tel;

    /**
     * 
     */
    private String sex;

    private static final long serialVersionUID = 1L;
}