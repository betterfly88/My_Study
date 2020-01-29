package com.rxjava.observable;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class ChapterOne {
    public CompletableFuture<String> combineFuture(){
        CompletableFuture<String> f1 = CompletableFuture.completedFuture("A");
        CompletableFuture<String> f2 = CompletableFuture.completedFuture("B");

        return f1.thenCombine(f2, (x, y) ->{
            return x + y;
        });
    }

    public Observable<String> combineObservable(){
        Observable<String> o1 = Observable.just("A");
        Observable<String> o2 = Observable.just("B");

        return Observable.zip(o1, o2, (x,y) ->{
            return x+y;
        });
    }

    public Single<String> getDataA(){
        return Single.<String> create(o ->{
            o.onSuccess("Data A");
        }).subscribeOn(Schedulers.io());
    }

    public Single<String> getDataB(){
        return Single.just("Data B")
                .subscribeOn(Schedulers.io());
    }

    public Completable writeToDatabase(Object data){
        return Completable.create(s ->{
//            doAsyncWrite(data, () -> s.onComplete(), error -> s.onError(new IllegalArgumentException()))
            if(data.equals(1)){
                System.out.println("성공");
                s.onComplete();
            }else{
                System.out.println("실패");
                s.onError(new IllegalArgumentException());
            }
        });
    }
}
