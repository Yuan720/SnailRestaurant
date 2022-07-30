package com.woniuxy.snailrestaurant.domain.vo;

import com.woniuxy.snailrestaurant.domain.Merchant;
import lombok.Data;

@Data
public class NearMerchantVo {
    Double distance;//距离
    Merchant merchant;//商家信息
}
