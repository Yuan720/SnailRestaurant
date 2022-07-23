package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.Dishes;
import com.woniuxy.snailrestaurant.service.DishesService;
import com.woniuxy.snailrestaurant.mapper.DishesMapper;
import org.springframework.stereotype.Service;

/**
* @author LeeYuan
* @description 针对表【dishes】的数据库操作Service实现
* @createDate 2022-07-23 12:06:43
*/
@Service
public class DishesServiceImpl extends ServiceImpl<DishesMapper, Dishes>
    implements DishesService{

}




