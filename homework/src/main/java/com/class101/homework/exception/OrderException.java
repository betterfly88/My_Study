package com.class101.homework.exception;

import com.class101.homework.common.ErrorStatus;

public class OrderException extends RuntimeException{
    private final ErrorStatus errorStatus;

    public OrderException(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }
}
