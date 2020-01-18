package com.rxjava.observable;

import io.reactivex.Observable;

public class Solution {
    public static void main(String[] args) {
//        helloRxWorld();
//        synchronouslyIncreaseIntegerValues();

        for(int i=0; i<10; i++){
            mergeObservable();
            System.out.println("====종료====");
        }
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

    public static void mergeObservable(){
        Observable<String> a = Observable.create(s ->{
            new Thread(()->{
                s.onNext("One");
                s.onNext("Two");
                s.onNext("Three");

                s.onComplete();
            }).start();
        });

//        a.subscribe(System.out::println);

        Observable<String> b = Observable.create(s ->{
            new Thread(()->{
                s.onNext("일");
                s.onNext("이");
                s.onNext("삼");

                s.onComplete();
            }).start();
        });

//        b.subscribe(System.out::println);

        Observable<String> c = Observable.merge(a, b);
        c.subscribe(System.out::println);
    }
}
