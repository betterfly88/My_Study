package com.rxjava.observable;

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

}