package com.betterfly.springbootmvc.exception;

/**
 * Created by betterfly
 * Date : 2019.03.18
 */
public class SampleException extends RuntimeException {
    private String setErrMessage(){
        return "Sample Exception error";
    }

    private String setErrReason(){
        return "The problem was caused by sleepiness.";
    }

    @Override
    public String getMessage() {
        return setErrMessage();
    }

    public String getReason(){
        return setErrReason();
    }

}
