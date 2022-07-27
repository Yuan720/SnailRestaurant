package com.woniuxy.snailrestaurant.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.domain.Merchant;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.snailrestaurant.domain.vo.NearMerchantVo;

import java.util.List;

/**
* @author LeeYuan
* @description 针对表【merchant(商家,餐厅表)】的数据库操作Service
* @createDate 2022-07-27 10:27:57
*/
public interface MerchantService extends IService<Merchant> {
    List<NearMerchantVo> getNearMerchant(Page page, String query);

}
