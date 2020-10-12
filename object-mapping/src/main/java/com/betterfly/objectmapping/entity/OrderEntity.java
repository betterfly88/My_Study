package com.betterfly.objectmapping.entity;

import com.betterfly.objectmapping.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class OrderEntity {
    private long serialNo;
    private long orderId;
    private String orderingUserName;
    private int orderStatus;
    private List<Product> orderProducts;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
}
