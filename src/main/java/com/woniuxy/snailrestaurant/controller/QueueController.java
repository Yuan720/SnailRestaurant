package com.woniuxy.snailrestaurant.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.snailrestaurant.common.CurrentUser;
import com.woniuxy.snailrestaurant.common.CurrentUserInfo;
import com.woniuxy.snailrestaurant.common.CustomResponse;
import com.woniuxy.snailrestaurant.common.OrderNumberGenerator;
import com.woniuxy.snailrestaurant.domain.QueueHistory;
import com.woniuxy.snailrestaurant.mapper.QueueHistoryMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Api(tags = "排号")
@RestController
@RequestMapping("/queue")
public class QueueController {

    @Resource
    QueueHistoryMapper queueHistoryMapper;

    @ApiOperation(value = "获取一个排队号")
    @PostMapping
    CustomResponse subQueue(@RequestParam("type") String type
            , @CurrentUser CurrentUserInfo info) {
        QueueHistory queueHistory = new QueueHistory();
        queueHistory.setQueueTime(new Date());
        queueHistory.setUserId(info.getId());
        queueHistory.setTableType(type);
        queueHistory.setStatus(0);
        int insert = queueHistoryMapper.insert(queueHistory);
        CustomResponse response = new CustomResponse()
                .setCode(10000)
                .setData('A' + OrderNumberGenerator.substringLast(String.valueOf(queueHistory.getId()), 4))
                .setMessage("ok");

        return response;
    }

    @GetMapping("/user")
    List<QueueHistory> getUserQueue(@CurrentUser CurrentUserInfo info) {
        QueryWrapper<QueueHistory> qwrapper = new QueryWrapper<>();
        qwrapper.eq("user_id", info.getId());
        List<QueueHistory> queueHistories = queueHistoryMapper.selectList(qwrapper);
        queueHistories.forEach(item->{
            item.setNumber('A'+OrderNumberGenerator.substringLast(String.valueOf(item.getId()),4));
        });
        return queueHistories;

    }

}
