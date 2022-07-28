package com.woniuxy.snailrestaurant.domain.vo;

import lombok.Data;

/*
* 订单概览
* */
@Data
public class OrderSummaryVo {
    String dishesName[];
    String images[];
    Integer status;
    Double total;
}
