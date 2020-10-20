package com.betterfly.objectmapping.model;

import lombok.Setter;

import java.time.LocalDateTime;

@Setter
public class Product {
    private String name;
    private Long price;
    private LocalDateTime productDate;
}
