package com.woniuxy.snailrestaurant.exception;

import com.woniuxy.snailrestaurant.common.CommonResultCode;
import lombok.Getter;

/*
 * 非法访问异常,通常就是没有权限
 * */
public class PermissionDeniedException extends BusinessException {

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public PermissionDeniedException() {
        super(CommonResultCode.PERMISSION_DENIED);
    }
}
