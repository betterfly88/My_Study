package com.kakao.common.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Customer {
    private Long customerNo;
    private String name;
    private LocalDate birth;
    private LocalDateTime regDateTime;
}