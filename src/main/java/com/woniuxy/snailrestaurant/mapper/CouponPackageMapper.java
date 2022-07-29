package com.woniuxy.snailrestaurant.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.woniuxy.snailrestaurant.domain.CouponPackage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
* @author LeeYuan
* @description 针对表【coupon_package(卡包)】的数据库操作Mapper
* @createDate 2022-07-25 20:27:40
* @Entity com.woniuxy.snailrestaurant.domain.CouponPackage
*/
public interface CouponPackageMapper extends BaseMapper<CouponPackage> {
    @Select("select * from coupon_package as cp inner join coupon as c on " +
            " cp.coupon_id = c.id ${ew.customSqlSegment}")
    IPage<CouponPackage> findPage(IPage page, @Param("ew") Wrapper wrapper);
}




