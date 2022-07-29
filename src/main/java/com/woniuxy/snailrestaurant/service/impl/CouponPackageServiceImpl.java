package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.CouponPackage;
import com.woniuxy.snailrestaurant.service.CouponPackageService;
import com.woniuxy.snailrestaurant.mapper.CouponPackageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author LeeYuan
* @description 针对表【coupon_package(卡包)】的数据库操作Service实现
* @createDate 2022-07-25 20:27:40
*/
@Service
public class CouponPackageServiceImpl extends ServiceImpl<CouponPackageMapper, CouponPackage>
    implements CouponPackageService{

    @Resource
    private CouponPackageMapper couponPackageMapper;

    @Override
    public IPage<CouponPackage> findByUserId(int offset, int pageSize, int userId, int status) {
        IPage page = new Page(offset,pageSize);
        QueryWrapper<CouponPackage> qw = new QueryWrapper<CouponPackage>();
        qw.eq("cp.user_id",userId);
        qw.eq("cp.status",status);
        IPage<CouponPackage>  a = couponPackageMapper.findPage(page,qw);
        return a;
    }
}




