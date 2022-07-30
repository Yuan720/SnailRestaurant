package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 排队历史
 * @TableName queue_history
 */
@Data
public class QueueHistory implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     *
     */
    private String number;

    /**
     * 取票时间
     */
    private Date queueTime;

    /**
     * 当前状态
     */
    private Integer status;
    private String tableType;

    private static final long serialVersionUID = 1L;
}
