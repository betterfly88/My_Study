package net.class101.server1.multi;

import org.junit.Before;
import org.junit.Test;

public class SumCalculatorTest {
    private SumCalculator sum;
    private MultiplyCalculator multiply;


    @Before
    public void setUp(){
        sum = new SumCalculator();
        multiply = new MultiplyCalculator();
    }

    @Test
    public void 곱셈_덧셈_동시수행(){
        sum.start();
        multiply.run();
    }
}