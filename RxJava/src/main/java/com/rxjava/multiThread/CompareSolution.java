package com.rxjava.multiThread;

import java.util.List;
import java.util.concurrent.*;

import static java.util.Arrays.asList;

public class CompareSolution {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        concurrencyTask();

        long end = System.currentTimeMillis() - start;
        System.out.println(end);


        long startFork = System.currentTimeMillis();
        parallelTask();

        long endFork = System.currentTimeMillis() - startFork;
        System.out.println(endFork);

    }


    public static void concurrencyTask() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Future<Long>> results = executor.invokeAll(asList(
                new Sums.Sum(0, 10), new Sums.Sum(100, 1_000), new Sums.Sum(10_000, 1_000_000), new Sums.Sum(100_000, 1_000_000_000)
        ));
        executor.shutdown();

        for (Future<Long> result : results) {
            System.out.println(result.get());
        }
    }

    public static void parallelTask() throws InterruptedException, ExecutionException {
        ForkJoinPool pool = new ForkJoinPool(4);

        List<Future<Long>> results = pool.invokeAll(asList(
                new Sums.Sum(0, 10), new Sums.Sum(100, 1_000), new Sums.Sum(10_000, 1_000_000), new Sums.Sum(100_000, 1_000_000_000)
        ));

        pool.invoke(new SumsForkJoin(0, 10));

        for (Future<Long> result : results) {
            System.out.println(result.get());
        }
    }
}
