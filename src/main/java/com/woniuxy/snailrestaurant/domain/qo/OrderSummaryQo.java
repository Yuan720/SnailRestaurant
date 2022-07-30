package com.woniuxy.snailrestaurant.domain.qo;

import lombok.Data;

/*
* 订单查询对象
* */
@Data
public class OrderSummaryQo {

    Integer status;
    String orderNum;

}
