package com.betterfly.objectmapping.proxy;

public class ExecutorServiceImpl implements ExecutorService{
    @Override
    public long getStartTime() {
        return System.currentTimeMillis();
    }

    @Override
    public void getExecuteTime(long startTime) {
        double secDiffTime = (System.currentTimeMillis() - startTime)/1000.0;

        System.out.println("실행시간(s) : "+secDiffTime);
    }
}
