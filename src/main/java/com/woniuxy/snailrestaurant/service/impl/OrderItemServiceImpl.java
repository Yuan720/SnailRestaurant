package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.OrderItem;
import com.woniuxy.snailrestaurant.service.OrderItemService;
import com.woniuxy.snailrestaurant.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author LeeYuan
* @description 针对表【order_item】的数据库操作Service实现
* @createDate 2022-07-25 20:27:40
*/
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem>
    implements OrderItemService{

    @Resource
    private OrderItemMapper orderItemMapper;
    @Override
    public List<OrderItem> findByOrderNumer(String orderNumber) {
        LambdaQueryWrapper<OrderItem> lqw = new LambdaQueryWrapper<OrderItem>();
        lqw.eq(OrderItem::getOrderNumber,orderNumber);
        List<OrderItem> oi= orderItemMapper.selectList(lqw);
        return oi;
    }
}




