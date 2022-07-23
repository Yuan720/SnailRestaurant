package com.woniuxy.snailrestaurant.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 座位
 * @TableName seat
 */
@Data
public class Seat implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 桌位外键
     */
    private Integer merchantTableId;

    /**
     * 座位号,简称,如A B,C,D
     */
    private String seatNick;

    private static final long serialVersionUID = 1L;
}