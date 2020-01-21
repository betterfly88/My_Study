package com.rxjava.multiThread;

import java.util.concurrent.RecursiveTask;

public class SumsForkJoin extends RecursiveTask<Long> {
    private final long from;
    private final long to;
    SumsForkJoin(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        System.out.println(Thread.currentThread().getName());

        long acc = 0;
        for (long i = from; i <= to; i++) {
            acc = acc + i;
        }
        return acc;
    }
}
