package com.woniuxy.snailrestaurant.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.domain.MemberCard;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.snailrestaurant.domain.qo.MemberCardQo;
import com.woniuxy.snailrestaurant.domain.vo.MemberDetailVo;

/**
* @author LeeYuan
* @description 针对表【member_card(会员卡7.28 19:14 更新)】的数据库操作Service
* @createDate 2022-07-28 19:26:21
*/
public interface MemberCardService extends IService<MemberCard> {

    Page<MemberDetailVo> listByCond(MemberCardQo memberCardQo, Integer pageNum, Integer pageSize);

}
