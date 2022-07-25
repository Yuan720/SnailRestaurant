package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.domain.QueueHistory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "排号")
@RestController
@RequestMapping("queue")
public class QueueController {

    @ApiOperation(value = "获取一个排队号")
    @GetMapping
    QueueHistory subQueue(){
        return null;
    }
}
