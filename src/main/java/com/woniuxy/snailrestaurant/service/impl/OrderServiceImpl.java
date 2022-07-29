package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.common.CommonResultCode;
import com.woniuxy.snailrestaurant.common.CurrentUserInfo;
import com.woniuxy.snailrestaurant.common.OrderNumberGenerator;
import com.woniuxy.snailrestaurant.domain.Dishes;
import com.woniuxy.snailrestaurant.domain.Order;
import com.woniuxy.snailrestaurant.domain.OrderItem;
import com.woniuxy.snailrestaurant.domain.dto.OrderDTO;
import com.woniuxy.snailrestaurant.exception.BusinessException;
import com.woniuxy.snailrestaurant.service.DishesService;
import com.woniuxy.snailrestaurant.service.OrderItemService;
import com.woniuxy.snailrestaurant.service.OrderService;
import com.woniuxy.snailrestaurant.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author LeeYuan
 * @description 针对表【order】的数据库操作Service实现
 * @createDate 2022-07-26 18:58:33
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {
    @Autowired
    DishesService dishesService;
    @Autowired
    OrderItemService orderItemService;

    @Transactional
    @Override
    public int delete(String orderNumber, Integer user_id) {
        return 0;
    }


    @Transactional
    @Override
    public boolean createOrder(OrderDTO dto, CurrentUserInfo info) {
        Order order = new Order();
        String orderNumber = OrderNumberGenerator.createOrderNumber(info.getId(), dto.getType());
        order.setCreateTime(new Date())
                .setCouponId(dto.getCouponId()).setOrderStatus(0)
                .setUserId(info.getId()).setDeliverInfoId(dto.getDeliverInfoId())
                .setMerchantId(dto.getMachineId()).setRemark(dto.getRemark())
                .setType(dto.getType()).setSeatId(dto.getSeatId())
                .setTableware(dto.getTableware()).setId(orderNumber);
        HashMap<Integer, Integer> disheInfo = dto.getDisheInfo();
        Set<Integer> dishes = disheInfo.keySet();
        QueryWrapper<Dishes> wrapper = new QueryWrapper<>();
        wrapper.in("id", dishes);
        List<Dishes> list = dishesService.list(wrapper);
        if (list.size() < disheInfo.size()) {
            throw new BusinessException(CommonResultCode.SOME_DISHES_OUT_OF_STOCK);
        }
        Double total_count = 0D;
        for (Dishes dishe : list) {
            total_count += dishe.getPrice() * disheInfo.get(dishe.getId());
        }
        order.setTotalCount(total_count);
        save(order);
        for (Dishes dishe : list) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderNumber(orderNumber);
            orderItem.setDeshesId(dishe.getId());
            if (dishe.getName().equals("打包费")) {
                orderItem.setType(2);
            } else {
                if (dishe.getName().equals("配送费")) {
                    orderItem.setType(3);
                } else {
                    orderItem.setType(1);
                }

            }
            if (dishe.getImages() != null) {
                orderItem.setImagekey(dishe.getImages().getImages()[0]);
            }
            orderItem.setPrice(dishe.getPrice());
            orderItem.setItemNum(disheInfo.get(dishe.getId()));
            orderItemService.save(orderItem);
        }
        return true;
    }
}




