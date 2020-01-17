package com.algorithm.timeConversion;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SolutionTestAA {

    @Test
    public void 검증(){
        //given, when
        String result = Solution.timeConversion("07:05:45PM");
        String result2 = Solution.timeConversion("07:05:45AM");
        String result3 = Solution.timeConversion("12:05:45AM");
        String result4 = Solution.timeConversion("12:05:45PM");

        //then
        assertTrue(result.equals("19:05:45"));
        assertTrue(result2.equals("07:05:45"));
        assertTrue(result3.equals("00:05:45"));
        assertTrue(result4.equals("12:05:45"));
    }
}