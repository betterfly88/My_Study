package com.rxjava.observable;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTestAA {

    @Test
    public void 계산기(){
        TestAA aa = new TestAA();

        int result = aa.cal(3 ,5);
        int result2 = aa.cal(2 ,5);
        int result3 = aa.cal(2 ,11);


        assertTrue(result == 8);
        assertTrue(result2 == 7);
        assertFalse(result3 == 10);
    }

}