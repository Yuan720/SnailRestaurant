package com.woniuxy.snailrestaurant.common;
/*
* 公共响应枚举
* */
public enum CommonResultCode {
    SUCCESS(10000,"操作成功"),
    INVALID_PARAM(10001,"无效参数"),
    PERMISSION_DENIED(10004,"没有权限"),
    FILE_TYPE_NOT_SUPORT(10005,"不支持的文件类型"),
    NO_USER_EXIST_RO_INCORRECT_CREDENTIAL(10006,"登录名或密码错误！"),
    SOME_DISHES_OUT_OF_STOCK(10008,"部分菜品已无库存！");

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
