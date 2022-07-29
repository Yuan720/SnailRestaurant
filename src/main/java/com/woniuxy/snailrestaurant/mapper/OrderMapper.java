package com.woniuxy.snailrestaurant.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.woniuxy.snailrestaurant.domain.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* @author LeeYuan
* @description 针对表【order】的数据库操作Mapper
* @createDate 2022-07-26 18:58:33
* @Entity com.woniuxy.snailrestaurant.domain.Order
*/
public interface OrderMapper extends BaseMapper<Order> {

    @Select("select * from order as o left join order_item as oi on " +
            " o.id = oi.order_number ${ew.customSqlSegment}")
    IPage<Order> findBystatus(IPage page, @Param("ew")Wrapper wrapper);
}




