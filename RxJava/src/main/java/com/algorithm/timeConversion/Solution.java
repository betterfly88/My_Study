package com.algorithm.timeConversion;

/**
 * https://www.hackerrank.com/challenges/time-conversion/problem
 *
 * Note :
 * Midnight is 12:00:00AM on a 12-hour clock and 00:00:00 on a 24-hour clock.
 * Noon     is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.
 */
public class Solution {
    static String timeConversion(String s) {

        return hourToStringValue(calculateHour(s)) + s.substring(2, s.length()-2);
    }

    private static String hourToStringValue(int h){
        String hour = String.valueOf(h);

        return hour.length() < 2 ? "0"+hour : hour;
    }

    private static int calculateHour(String hour){
        int hourVal = Integer.parseInt(hour.split(":")[0]);

        if(hour.contains("PM") && hourVal < 12){
            hourVal += 12;
        }

        if(hour.contains("AM") && hourVal == 12){
            hourVal = 0;
        }


        return hourVal > 23 ? 0 : hourVal;
    }

}
