package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 这是用户表,代表所有注册用户,不包括商家端用户
 * @TableName user
 */
@Data
public class User implements Serializable {

    /**
     * 用户主键
     */
    private Integer id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 哈希密码 sha256 64位十六进制字符
     */
    @NotBlank(message = "密码不能为空")
    private String hashedPasswd;

    /**
     * 枚举 可能是手机号用户 微信用户
     */
    private Integer accountType;

    /**
     * 手机号
     */
    private String tel;

    private static final long serialVersionUID = 1L;
}