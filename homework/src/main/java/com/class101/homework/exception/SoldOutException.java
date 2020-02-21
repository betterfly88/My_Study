package com.class101.homework.exception;

public class SoldOutException extends RuntimeException {

    public SoldOutException(String message) {
        super(message);
    }
}
