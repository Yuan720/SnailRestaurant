package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.MemberCard;
import com.woniuxy.snailrestaurant.domain.qo.MemberCardQo;
import com.woniuxy.snailrestaurant.domain.vo.MemberDetailVo;
import com.woniuxy.snailrestaurant.service.MemberCardService;
import com.woniuxy.snailrestaurant.mapper.MemberCardMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LeeYuan
 * @description 针对表【member_card(会员卡7.28 19:14 更新)】的数据库操作Service实现
 * @createDate 2022-07-28 19:26:21
 */
@Service
public class MemberCardServiceImpl extends ServiceImpl<MemberCardMapper, MemberCard>
        implements MemberCardService {

    @Resource
    private MemberCardMapper memberCardMapper;

    @Override
    public Page<MemberDetailVo> listByCond(MemberCardQo memberCardQo, Integer pageNum, Integer pageSize) {
        Page<MemberDetailVo> page = new Page<MemberDetailVo>(pageNum, pageSize);

        return memberCardMapper.selectBycondion(page, memberCardQo);
    }
}




