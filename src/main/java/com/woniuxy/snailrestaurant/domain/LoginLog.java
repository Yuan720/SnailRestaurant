package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName login_log
 */
@Data
public class LoginLog implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 用户外键
     */
    private Integer empId;

    /**
     * 登录ip
     */
    private String loginIp;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 登出时间
     */
    private Date logoutTime;

    private static final long serialVersionUID = 1L;
}