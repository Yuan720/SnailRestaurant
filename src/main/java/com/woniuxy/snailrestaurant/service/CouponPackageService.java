package com.woniuxy.snailrestaurant.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.woniuxy.snailrestaurant.domain.CouponPackage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PutMapping;

import java.sql.Wrapper;

/**
* @author LeeYuan
* @description 针对表【coupon_package(卡包)】的数据库操作Service
* @createDate 2022-07-25 20:27:40
*/
public interface CouponPackageService extends IService<CouponPackage> {
    IPage<CouponPackage> findByUserId(int offset,int pageSize,int userId,int status);
}
