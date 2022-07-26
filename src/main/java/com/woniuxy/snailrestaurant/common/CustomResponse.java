package com.woniuxy.snailrestaurant.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CustomResponse {
    int code;
    String msg;
    String data;
}
