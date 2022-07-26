package com.woniuxy.snailrestaurant.common;
/*
* 公共响应枚举
* */
public enum CommonResultCode {
    SUCCESS(10000,"操作成功"),
    INVALID_PARAM(10001,"无效参数"),
    PERMISSION_DENIED(10004,"没有权限"),
    NO_USER_EXIST_RO_INCORRECT_CREDENTIAL(10006,"登录名或密码错误！");

    CommonResultCode(Integer code, String msg) {
        this.code =code;
        this.msg =msg;
    }
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

}
