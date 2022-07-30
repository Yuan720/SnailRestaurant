package com.woniuxy.snailrestaurant.domain.dto;

import com.sun.istack.internal.Nullable;
import lombok.Data;

import java.util.HashMap;

@Data
public class OrderDTO {
    //菜品-数量键值对
   HashMap<Integer, Integer> disheInfo;
    //收餐地址id
    Integer deliverInfoId;
    //优惠券id
    Integer couponId;
    //订单类型
    Integer type;
    //桌号
    Integer tableId;
    //座位号
    Integer seatId;
    //机器id
    Integer machineId;
    //操作员id
    Integer operatorId;
    //备注
    String remark;
    //餐具数量
    Integer tableware;
    Integer couponPackageId;

}
