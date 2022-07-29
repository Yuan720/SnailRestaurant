package com.woniuxy.snailrestaurant.domain.dto;

import lombok.Data;

@Data
public class ReviewDTO {

    private int star;
    private int dishesId;
    private int userId;
    private String review;
}
