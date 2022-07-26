package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.PaymentMethod;
import com.woniuxy.snailrestaurant.service.PaymentMethodService;
import com.woniuxy.snailrestaurant.mapper.PaymentMethodMapper;
import org.springframework.stereotype.Service;

/**
* @author LeeYuan
* @description 针对表【payment_method】的数据库操作Service实现
* @createDate 2022-07-25 20:27:41
*/
@Service
public class PaymentMethodServiceImpl extends ServiceImpl<PaymentMethodMapper, PaymentMethod>
    implements PaymentMethodService{

}




