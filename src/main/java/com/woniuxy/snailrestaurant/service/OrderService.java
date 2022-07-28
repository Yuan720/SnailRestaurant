package com.woniuxy.snailrestaurant.service;

import com.woniuxy.snailrestaurant.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author LeeYuan
* @description 针对表【order】的数据库操作Service
* @createDate 2022-07-26 18:58:33
*/
public interface OrderService extends IService<Order> {
    /**
     * 删除订单
     * @param orderNumber
     * @param user_id
     * @return
     */
    int delete(String orderNumber,Integer user_id);
}
