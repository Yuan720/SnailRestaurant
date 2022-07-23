package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.Seat;
import com.woniuxy.snailrestaurant.service.SeatService;
import com.woniuxy.snailrestaurant.mapper.SeatMapper;
import org.springframework.stereotype.Service;

/**
* @author LeeYuan
* @description 针对表【seat(座位)】的数据库操作Service实现
* @createDate 2022-07-23 12:06:44
*/
@Service
public class SeatServiceImpl extends ServiceImpl<SeatMapper, Seat>
    implements SeatService{

}




