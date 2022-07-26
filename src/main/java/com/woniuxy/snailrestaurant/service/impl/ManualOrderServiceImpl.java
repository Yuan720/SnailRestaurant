package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.ManualOrder;
import com.woniuxy.snailrestaurant.service.ManualOrderService;
import com.woniuxy.snailrestaurant.mapper.ManualOrderMapper;
import org.springframework.stereotype.Service;

/**
* @author LeeYuan
* @description 针对表【manual_order(人工点单生成的订单记录)】的数据库操作Service实现
* @createDate 2022-07-26 19:26:10
*/
@Service
public class ManualOrderServiceImpl extends ServiceImpl<ManualOrderMapper, ManualOrder>
    implements ManualOrderService{

}




