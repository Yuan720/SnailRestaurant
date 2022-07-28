package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.Order;
import com.woniuxy.snailrestaurant.service.OrderService;
import com.woniuxy.snailrestaurant.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author LeeYuan
* @description 针对表【order】的数据库操作Service实现
* @createDate 2022-07-26 18:58:33
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

    @Transactional
    @Override
    public int delete(String orderNumber, Integer user_id) {
        return 0;
    }
}




