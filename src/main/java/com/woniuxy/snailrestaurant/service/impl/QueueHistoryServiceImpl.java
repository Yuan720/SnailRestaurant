package com.woniuxy.snailrestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.snailrestaurant.domain.QueueHistory;
import com.woniuxy.snailrestaurant.service.QueueHistoryService;
import com.woniuxy.snailrestaurant.mapper.QueueHistoryMapper;
import org.springframework.stereotype.Service;

/**
* @author LeeYuan
* @description 针对表【queue_history(排队历史)】的数据库操作Service实现
* @createDate 2022-07-25 20:27:41
*/
@Service
public class QueueHistoryServiceImpl extends ServiceImpl<QueueHistoryMapper, QueueHistory>
    implements QueueHistoryService{

}




