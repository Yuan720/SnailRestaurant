package com.woniuxy.snailrestaurant.service;

import com.woniuxy.snailrestaurant.domain.Merchant;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.snailrestaurant.domain.geo.Geo;

import java.util.List;

/**
* @author LeeYuan
* @description 针对表【merchant(商家,餐厅表)】的数据库操作Service
* @createDate 2022-07-22 16:41:39
*/
public interface MerchantService extends IService<Merchant> {
    /*
    *获取附近商家
    * @Param location 请求的坐标
    * @return 附近的商家列表
    *  */

    List<Merchant> getNearMerchan(Geo location);

}
