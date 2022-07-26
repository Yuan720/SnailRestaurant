package com.woniuxy.snailrestaurant.exception;

import com.woniuxy.snailrestaurant.common.CommonResultCode;
import lombok.Getter;

public class BusinessException extends RuntimeException {
    @Getter
    int code;
    public  BusinessException(CommonResultCode resultCode){
        super(resultCode.getMsg());
        this.code=resultCode.getCode();
    }
}
