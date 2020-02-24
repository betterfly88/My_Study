package net.class101.server1.exception;

import net.class101.server1.common.ErrorStatus;

public class OrderException extends RuntimeException{
    private final ErrorStatus errorStatus;

    public OrderException(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }
}
