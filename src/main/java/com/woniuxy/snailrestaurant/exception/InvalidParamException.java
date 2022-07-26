package com.woniuxy.snailrestaurant.exception;

import com.woniuxy.snailrestaurant.common.CommonResultCode;
import lombok.Getter;

/*
* 参数无效异常
* */
public class InvalidParamException extends RuntimeException{

    @Getter
    int code;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public InvalidParamException() {
        super(CommonResultCode.INVALID_PARAM.getMsg());
        this.code=CommonResultCode.INVALID_PARAM.getCode();

    }
}
