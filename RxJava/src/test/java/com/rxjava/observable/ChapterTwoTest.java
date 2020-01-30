package com.rxjava.observable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChapterTwoTest {

    private ChapterTwo target;

    @Before
    public void init(){
        target = new ChapterTwo();
    }


    @Test
    public void Observable_예외처리(){
        /*
        처리 중 예외를 던지는데,
        Throwable하지 않는다면 onErrorImplementaion 내용이 필요하다고 한다.
        throw를 처리해줄 Throwable 이 필요함!!
         */
        target.exceptionHandler("a, b, c");
    }

}