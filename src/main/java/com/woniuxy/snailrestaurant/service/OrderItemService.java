package com.woniuxy.snailrestaurant.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.woniuxy.snailrestaurant.domain.OrderItem;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
* @author LeeYuan
* @description 针对表【order_item】的数据库操作Service
* @createDate 2022-07-25 20:27:40
*/
public interface OrderItemService extends IService<OrderItem> {
    List<OrderItem> findByOrderNumer(String orderNumber);

}
