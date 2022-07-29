package com.woniuxy.snailrestaurant.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.woniuxy.snailrestaurant.domain.Order;
import com.woniuxy.snailrestaurant.domain.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetailVo {

    Order meta;

    List<OrderItem> items;
}
