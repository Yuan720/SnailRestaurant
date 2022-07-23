package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName merchan_profile
 */
@Data
public class MerchanProfile implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 门店地址
     */
    private String merchantAddr;

    /**
     * 门店电话
     */
    private String merchantTel;

    /**
     * 门店二维码图片存储地址的字符串id
     */
    private String merchantOrcode;

    /**
     * 门店微信公众号二维码图片存储地址的字符串id
     */
    private String merchantWx;

    /**
     * 门店微信小程序二维码存储地址的字符串id
     */
    private String merchantMiniProgram;

    /**
     * 门店自我介绍id
     */
    private String merchantSelfDesc;

    /**
     * 门店执照图片id
     */
    private String merchantLisence;

    /**
     * 开业时间
     */
    private Date openTime;

    /**
     * 人数
     */
    private Integer employeeCount;

    /**
     * 商家外键
     */
    private Integer merchantId;

    private static final long serialVersionUID = 1L;
}