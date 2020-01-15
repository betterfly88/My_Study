package com.rxjava.observable;

import io.reactivex.Observable;

public class Solution {
    public static void main(String[] args) {
        helloRxWorld();
        synchronouslyIncreaseIntegerValues();
    }

    public static void helloRxWorld(){
        Observable.create(s ->{
            s.onNext("Hello, RxJava World!");
            s.onComplete();
        }).subscribe(System.out::println);
    }


    // synchronous computation

    /**
     * map(), filter(), take, flatMap(), groupBy()
     *
     * Most of these operators are synchronous,
     * meaning that they perform their computation synchronously inside the onNext() as the events pass by.
     */
    public static void synchronouslyIncreaseIntegerValues(){
        Observable<Integer> o = Observable.create(s ->{
            for(int i=0; i<100; i++){
                s.onNext(i);
            }

            s.onComplete();
        });


        o.map(i -> "Number : "+ i)
                .subscribe(System.out::println);
    }
}
