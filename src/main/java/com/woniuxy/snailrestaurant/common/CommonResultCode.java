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
    SOME_DISHES_OUT_OF_STOCK(10008,"部分菜品已无库存！"),
    NO_SUCH_COUPON(10009,"优惠券不存在"),
    NO_SUCH_ORDER(10010,"订单不存在"),
    FAIL_RECEIVE(10012,"优惠券截止日期已过或者已达到领取优惠券上限张数"),
    INVALID_COUPON(10011,"优惠券无效");;

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
