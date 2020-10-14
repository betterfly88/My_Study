package com.betterfly.objectmapping.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class OrderDto {
    private long serialNo;
    private long orderId;
    private String orderingUserName;
    private int status;
    private List<Product> orderProducts;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
}
