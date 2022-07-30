package com.woniuxy.snailrestaurant.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.domain.MemberCard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.snailrestaurant.domain.qo.MemberCardQo;
import com.woniuxy.snailrestaurant.domain.vo.MemberDetailVo;
import org.apache.ibatis.annotations.Param;

/**
* @author LeeYuan
* @description 针对表【member_card(会员卡7.28 19:14 更新)】的数据库操作Mapper
* @createDate 2022-07-28 19:26:21
* @Entity com.woniuxy.snailrestaurant.domain.MemberCard
*/
public interface MemberCardMapper extends BaseMapper<MemberCard> {

    Page<MemberDetailVo> selectBycondion(Page<MemberDetailVo> page,@Param("mq") MemberCardQo mq);


}




