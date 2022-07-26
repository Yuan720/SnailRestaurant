package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.MemberCard;
import com.woniuxy.snailrestaurant.service.MemberCardService;
import com.woniuxy.snailrestaurant.mapper.MemberCardMapper;
import org.springframework.stereotype.Service;

/**
* @author LeeYuan
* @description 针对表【member_card(会员卡)】的数据库操作Service实现
* @createDate 2022-07-26 18:58:46
*/
@Service
public class MemberCardServiceImpl extends ServiceImpl<MemberCardMapper, MemberCard>
    implements MemberCardService{

}




