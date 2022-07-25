package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 预定
 * @TableName booking_order
 */
@Data
public class BookingOrder implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 预定日期
     */
    private Date bookingDate;

    /**
     * 使用时间从..起
     */
    private Date useTimeFrom;

    /**
     * 使用时间到
     */
    private Date useTimeTo;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 电话
     */
    private String tel;

    /**
     * 备注
     */
    private String remark;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    private static final long serialVersionUID = 1L;
}