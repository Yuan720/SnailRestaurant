package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.Merchant;
import com.woniuxy.snailrestaurant.domain.geo.Geo;
import com.woniuxy.snailrestaurant.service.MerchantService;
import com.woniuxy.snailrestaurant.mapper.MerchantMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author LeeYuan
* @description 针对表【merchant(商家,餐厅表)】的数据库操作Service实现
* @createDate 2022-07-22 16:41:39
*/
@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant>
    implements MerchantService{

    @Override
    public List<Merchant> getNearMerchan(Geo location) {
        return null;
    }
}



