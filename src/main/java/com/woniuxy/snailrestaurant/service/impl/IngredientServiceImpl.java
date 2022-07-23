package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.Ingredient;
import com.woniuxy.snailrestaurant.service.IngredientService;
import com.woniuxy.snailrestaurant.mapper.IngredientMapper;
import org.springframework.stereotype.Service;

/**
* @author LeeYuan
* @description 针对表【ingredient(原料表)】的数据库操作Service实现
* @createDate 2022-07-23 12:06:44
*/
@Service
public class IngredientServiceImpl extends ServiceImpl<IngredientMapper, Ingredient>
    implements IngredientService{

}




