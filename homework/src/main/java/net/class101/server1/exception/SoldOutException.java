package net.class101.server1.exception;

public class SoldOutException extends RuntimeException {

    public SoldOutException(String message) {
        super(message);
    }
}
