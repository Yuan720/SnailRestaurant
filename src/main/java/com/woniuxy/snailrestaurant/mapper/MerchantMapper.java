package com.woniuxy.snailrestaurant.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.domain.Merchant;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.snailrestaurant.domain.vo.NearMerchantVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LeeYuan
 * @description 针对表【merchant(商家,餐厅表)】的数据库操作Mapper
 * @createDate 2022-07-27 15:05:08
 * @Entity com.woniuxy.snailrestaurant.domain.Merchant
 */
public interface MerchantMapper extends BaseMapper<Merchant> {
    List<NearMerchantVo> getNear(Page<NearMerchantVo> merchantVoPage, @Param("query") String query);

}




