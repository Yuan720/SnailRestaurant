package com.woniuxy.snailrestaurant.service;

import com.woniuxy.snailrestaurant.common.CurrentUserInfo;
import com.woniuxy.snailrestaurant.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.snailrestaurant.domain.dto.OrderDTO;
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

    boolean createOrder(OrderDTO dto, CurrentUserInfo info);
    boolean payOrder(String orderNum, Integer methodId);
    /*
    *@param pre_count 未进行折扣前的金额
    * @param couponId 使用的优惠券
    * @return 折扣后的金额
    **/
    double billCount(double pre_count,int couponId);




}
