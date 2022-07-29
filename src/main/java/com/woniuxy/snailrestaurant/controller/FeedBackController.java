package com.woniuxy.snailrestaurant.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.snailrestaurant.common.CurrentUser;
import com.woniuxy.snailrestaurant.common.CurrentUserInfo;
import com.woniuxy.snailrestaurant.domain.Feedback;
import com.woniuxy.snailrestaurant.domain.FeedbackType;
import com.woniuxy.snailrestaurant.service.FeedbackService;
import com.woniuxy.snailrestaurant.service.FeedbackTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "反馈")
@RestController
@RequestMapping("/feedback")
public class FeedBackController {
    @Autowired
    FeedbackTypeService typeService;
    @Autowired
    FeedbackService service;

    @ApiOperation("提交反馈")
    @PostMapping
    boolean addFeedBack(@CurrentUser CurrentUserInfo info,
                        @RequestBody Feedback feedBack) {

        feedBack.setUserId(info.getId());
        boolean save = service.save(feedBack);
        return save;
    }

    @ApiOperation(value = "列出反馈类型")
    @GetMapping("/types")
    List<FeedbackType> listAll() {
        List<FeedbackType> feedbackTypes = typeService.getBaseMapper().selectList(null);
        return feedbackTypes;
    }

}
