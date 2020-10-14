package com.betterfly.objectmapping.entity;

import com.betterfly.objectmapping.model.Product;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    private long serialNo;
    private long orderId;
    private String orderingUserName;
    private int orderStatus;
    private List<Product> orderProducts;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
}
