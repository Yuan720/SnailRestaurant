package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName employee
 */
@Data
public class Employee implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String tel;

    /**
     * 家庭住址
     */
    private String homeAddr;

    /**
     * 所属商家
     */
    private Integer merchantId;

    /**
     * 入职日期
     */
    private Date joinDate;

    /**
     * 外键 职位id
     */
    private Integer jobId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 登录账户
     */
    private String accountName;

    /**
     * 身份证正面图片key
     */
    private String frontIdcard;

    /**
     * 身份证反面图片key
     */
    private String backIdcard;

    private static final long serialVersionUID = 1L;
}