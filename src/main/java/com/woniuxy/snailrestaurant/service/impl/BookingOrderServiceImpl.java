package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.BookingOrder;
import com.woniuxy.snailrestaurant.service.BookingOrderService;
import com.woniuxy.snailrestaurant.mapper.BookingOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author LeeYuan
* @description 针对表【booking_order(预定)】的数据库操作Service实现
* @createDate 2022-07-25 20:27:40
*/
@Service
public class BookingOrderServiceImpl extends ServiceImpl<BookingOrderMapper, BookingOrder>
    implements BookingOrderService{



}




