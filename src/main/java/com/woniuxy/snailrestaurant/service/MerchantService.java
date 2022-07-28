package com.woniuxy.snailrestaurant.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.domain.Merchant;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.snailrestaurant.domain.vo.NearMerchantVo;

import java.util.List;

/**
* @author LeeYuan
* @description 针对表【merchant(商家,餐厅表)】的数据库操作Service
* @createDate 2022-07-27 15:05:08
*/
public interface MerchantService extends IService<Merchant> {

        Page<List<NearMerchantVo>> getNear(Page<NearMerchantVo> merchantVoPage, String query);
}
