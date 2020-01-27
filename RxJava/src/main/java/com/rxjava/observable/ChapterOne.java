package com.rxjava.observable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class ChapterOne {
    public CompletableFuture<String> combineFuture(){
        CompletableFuture<String> f1 = CompletableFuture.completedFuture("A");
        CompletableFuture<String> f2 = CompletableFuture.completedFuture("B");

        return f1.thenCombine(f2, (x, y) ->{
            return x + y;
        });
    }

}
