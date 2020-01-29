package com.rxjava.observable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ChapterOneTest {
    private ChapterOne target;

    @Before
    public void init(){
        target = new ChapterOne();
    }


    @Test
    public void combineFuture() throws ExecutionException, InterruptedException {

        assertThat(target.combineFuture().get(), is("AB"));
    }


    @Test
    public void combineObservable(){
        assertThat(target.combineObservable().blockingSingle(), is("AB"));
    }

    @Test
    public void Single_장점(){
        System.out.println(target.getDataA().blockingGet());
        System.out.println(target.getDataB().blockingGet());

        // Observable 스트림으로 병합
        Flowable<String> a_merge_b = target.getDataA().mergeWith(target.getDataB());

        // 출력 순서는 A,B 순서를 보장하지 않는다. (각각의 처리 순서대로)
        a_merge_b.blockingSubscribe(v ->{
            System.out.println(v);
        });


    }

    @Test
    public void 반환값이필요없는_Completable(){
        target.writeToDatabase(1).blockingGet();
    }
}