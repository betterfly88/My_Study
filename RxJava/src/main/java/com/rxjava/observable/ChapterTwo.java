package com.rxjava.observable;

import io.reactivex.Observable;

import java.util.List;

public class ChapterTwo {

    public Observable<String> exceptionHandler(String a){
        Observable<String> o1 = Observable.just(a);

        o1.subscribe(
                (String s) -> {
                    System.out.println(s);
                    throw new IllegalArgumentException();
                }

                ,(Throwable t) -> {t.printStackTrace();}

        );

        return o1;
    }
}
