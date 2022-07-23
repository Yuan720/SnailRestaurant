package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName merchant_account
 */
@Data
public class MerchantAccount implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 商家外键
     */
    private Integer merchantId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String hashedPasswd;

    /**
     * 角色
     */
    private Integer role;

    /**
     * 外键
     */
    private Integer employeeId;

    private static final long serialVersionUID = 1L;
}