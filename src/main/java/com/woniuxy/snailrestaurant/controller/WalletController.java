package com.woniuxy.snailrestaurant.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "钱包")
@RestController
@RequestMapping("/wallet")
public class WalletController {

    @ApiOperation(value = "钱包充值")
    @PutMapping
    int charge(int userId){
        return 0;
    }
    @ApiOperation("扫码付,其实就是生成唯一身份识别字符串")
    @GetMapping
    String getIdentyfy(){
        return null;
    }
    @ApiOperation("储值记录,如果带有参数月份则精确查询,否则列出所有")
    @GetMapping("/charge")
    List getChargeRecord(Integer month){
        return null;
    }

    @ApiOperation("消费记录,如果带有参数月份则精确查询,否则列出所有")
    @GetMapping("/expenses")
    List expensesRecord(Integer month){
        return null;
    }

}
