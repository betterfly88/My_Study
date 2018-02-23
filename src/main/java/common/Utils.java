package common;

import java.util.ArrayList;

/**
 * Created by betterFLY on 2018. 2. 24.
 * Github : http://github.com/betterfly88
 */

public class Utils {
    // Stirng -> Double 파싱
    public static double parseDouble(String tempString){
        return Double.parseDouble(tempString);
    }

    // 문자열 쪼개기
    public static ArrayList<String> splitValue(String value){
        String [] tempArray = value.split(" ");

        ArrayList arrStr = new ArrayList<String>();
        for(String temp : tempArray){
            arrStr.add(temp);
        }
        return arrStr;
    }
}
