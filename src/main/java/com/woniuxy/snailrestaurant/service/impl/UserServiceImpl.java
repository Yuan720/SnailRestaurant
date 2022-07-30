package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.common.CommonResultCode;
import com.woniuxy.snailrestaurant.domain.Coupon;
import com.woniuxy.snailrestaurant.domain.CouponPackage;
import com.woniuxy.snailrestaurant.domain.User;
import com.woniuxy.snailrestaurant.exception.BusinessException;
import com.woniuxy.snailrestaurant.mapper.CouponMapper;
import com.woniuxy.snailrestaurant.mapper.CouponPackageMapper;
import com.woniuxy.snailrestaurant.service.UserService;
import com.woniuxy.snailrestaurant.mapper.UserMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @author LeeYuan
* @description 针对表【user(这是用户表,代表所有注册用户,不包括商家端用户)】的数据库操作Service实现
* @createDate 2022-07-25 20:27:41
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private CouponMapper couponMapper;
    @Resource
    private CouponPackageMapper couponPackageMapper;

    @Transactional
    @Override
    public int receiveCoupon(int userId,int couponId) {

        LambdaQueryWrapper<CouponPackage> lqw = new LambdaQueryWrapper<>();
        lqw.eq(CouponPackage::getCouponId,couponId);
        int count = couponPackageMapper.selectCount(lqw);
        Coupon coupon = couponMapper.selectById(couponId);
        int couponleft = coupon.getLeft();
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        ft.format(date);
        CouponPackage couponPackage = new CouponPackage();
        int insert = 0;

        if(couponleft > 0 & date.before(coupon.getEndTime()) & date.after(coupon.getStartTime()) & count<coupon.getLimitPer()){
            couponleft = couponleft-1;
            coupon.setLeft(couponleft);
            couponMapper.updateById(coupon);
            couponPackage.setUserId(userId);
            couponPackage.setCouponId(couponId);
            couponPackage.setPickTime(date);
            couponPackage.setStatus(0);
            insert = couponPackageMapper.insert(couponPackage);
        }else {
            throw new BusinessException(CommonResultCode.FAIL_RECEIVE);
        }
        return insert;
    }
}




