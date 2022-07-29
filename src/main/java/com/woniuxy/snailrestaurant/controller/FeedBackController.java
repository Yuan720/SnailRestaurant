package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.common.CurrentUser;
import com.woniuxy.snailrestaurant.common.CurrentUserInfo;
import com.woniuxy.snailrestaurant.domain.Feedback;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "反馈")
@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    @PostMapping
    int addFeedBack(@CurrentUser CurrentUserInfo info,
                    @RequestBody Feedback feedBack) {

        return 0;
    }

}
