package com.algorithm.timeConversion;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest{

    @Test
    public void 시간확인(){
        //given & when
        String hour = Solution.hourToStringValue(9);

        //then
        assertTrue(hour.equals("09"));

    }
}