package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.common.CommonResultCode;
import com.woniuxy.snailrestaurant.common.CurrentUserInfo;
import com.woniuxy.snailrestaurant.common.OrderNumberGenerator;
import com.woniuxy.snailrestaurant.common.PaymentMethod;
import com.woniuxy.snailrestaurant.domain.*;
import com.woniuxy.snailrestaurant.domain.dto.OrderDTO;
import com.woniuxy.snailrestaurant.exception.BusinessException;
import com.woniuxy.snailrestaurant.payment.PaymentHandler;
import com.woniuxy.snailrestaurant.payment.PaymentHandlerFactory;
import com.woniuxy.snailrestaurant.service.*;
import com.woniuxy.snailrestaurant.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * @author LeeYuan
 * @description 针对表【order】的数据库操作Service实现
 * @createDate 2022-07-26 18:58:33
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {
    @Autowired
    DishesService dishesService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    CouponPackageService couponPackageService;
    @Autowired
    PaymentHandlerFactory paymentHandlerFactory;

    @Autowired
    CouponService couponService;

    @Transactional
    @Override
    public int delete(String orderNumber, Integer user_id) {
        return 0;
    }


    @Transactional
    @Override
    public boolean createOrder(OrderDTO dto, CurrentUserInfo info) {
        CouponPackage byCondition = couponPackageService.findByCondition(dto.getCouponPackageId(), info.getId(), dto.getCouponId());
        if (Objects.isNull(byCondition)) {
            throw new BusinessException(CommonResultCode.NO_SUCH_COUPON);
        }
        Order order = new Order();
        String orderNumber = OrderNumberGenerator.createOrderNumber(info.getId(), dto.getType());
        order.setCreateTime(new Date())
                .setCouponId(dto.getCouponId()).setOrderStatus(0)
                .setUserId(info.getId()).setDeliverInfoId(dto.getDeliverInfoId())
                .setMerchantId(dto.getMachineId()).setRemark(dto.getRemark())
                .setType(dto.getType()).setSeatId(dto.getSeatId())
                .setTableware(dto.getTableware()).setId(orderNumber)
                .setCouponPackageId(dto.getCouponPackageId());
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
        order.setTotalCount(billCount(total_count, dto.getCouponId()));
        save(order);
        ArrayList<OrderItem> items = new ArrayList<>();
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
            items.add(orderItem);
        }
        orderItemService.saveBatch(items);
        return true;
    }


    @Transactional
    @Override
    public boolean payOrder(String orderNum, Integer methodId) {
        PaymentMethod method = null;
        switch (methodId) {
            case 0:
                method = PaymentMethod.WX_PAY;
                break;
            case 1:
                method = PaymentMethod.ALIPAY;
                break;
            case 2:
                method = PaymentMethod.CASH_PAY;
                break;
            case 3:
                method = PaymentMethod.BANKCARD_PAY;
                break;
            case 4:
                method = PaymentMethod.MEMBER_CARD_PAY;
                break;
            default:
                new BusinessException(CommonResultCode.INVALID_PARAM);
        }

        PaymentHandler instance = paymentHandlerFactory.getInstance(method);
        return instance.handlePayment(orderNum);
    }

    @Override
    public double billCount(double pre_count, int couponId) {
        Coupon byId = couponService.getById(couponId);
        assert byId != null;
        if (!verifyCoupon(byId, pre_count)) {
            //如果原价券,则没有优惠
            log.info("不满足优惠条件,原价输出...");
            return pre_count;
        }
        //满减
        if (byId.getType() == 1 || byId.getType() == 3) {
            return pre_count - byId.getValue().doubleValue();

        }
        //打折
        if (byId.getType() == 2 || byId.getType() == 4) {
            return pre_count * byId.getDiscount() / 100;
        }

        return pre_count;

    }

    boolean verifyCoupon(Coupon coupon) {
        Date now = new Date();
        if (coupon.getEndTime().before(now)) {
            return false;
        }
        if (coupon.getStartTime().after(now)) {
            return false;
        }
        return true;
    }

    boolean verifyCoupon(Coupon coupon, double payMount) {
        if (verifyCoupon(coupon)) {
            if (payMount > coupon.getMinimumPay().doubleValue()) {
                return true;
            }
        }
        return false;
    }
}




