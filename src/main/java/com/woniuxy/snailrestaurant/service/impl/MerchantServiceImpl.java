package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.Merchant;
import com.woniuxy.snailrestaurant.domain.vo.NearMerchantVo;
import com.woniuxy.snailrestaurant.service.MerchantService;
import com.woniuxy.snailrestaurant.mapper.MerchantMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LeeYuan
 * @description 针对表【merchant(商家,餐厅表)】的数据库操作Service实现
 * @createDate 2022-07-27 15:05:08
 */
@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant>
        implements MerchantService {
    @Resource
    MerchantMapper mapper;

    @Override
    public List<NearMerchantVo> getNear(Page<NearMerchantVo> merchantVoPage, String query) {

      return   mapper.getNear(merchantVoPage,query);
    }
}




