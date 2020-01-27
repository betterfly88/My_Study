package com.rxjava.observable;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
//        helloRxWorld();
//        synchronouslyIncreaseIntegerValues();
//        for(int i=0; i<10; i++){
//            mergeObservable();
//            System.out.println("===================");
//            Thread.sleep(500);
//        }


//        generateInitials();
        generateObInitials();
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


    public static void generateInitials(){
        getDataFromLocalMemorySynchronously()
                .skip(10)
                .limit(5)
                .map(s -> s + "_transformed")
                .forEach(System.out::println);
    }

    public static void generateObInitials(){
        getObDataFromLocalMemorySynchronously()
                .skip(10)
                .take(5)
                .map(s -> s + "_ob_trans")
                .subscribe(System.out::println);
    }

    public static Stream<String> getDataFromLocalMemorySynchronously(){

        return Stream.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"
                , "K", "L", "M", "N", "O"
                , "P", "Q", "R", "S", "T");
    }

    public static Observable<String> getObDataFromLocalMemorySynchronously(){

        return Observable.fromArray("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"
                , "K", "L", "M", "N", "O"
                , "P", "Q", "R", "S", "T");
    }
}
