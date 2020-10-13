package com.betterfly.objectmapping.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class OrderDto {
    private long serialNo;
    private long orderId;
    private String orderingUserName;
    private int status;
    private List<Product> orderProducts;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
}
