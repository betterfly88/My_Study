package service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterFLY on 2018. 2. 19.
 * Github : http://github.com/betterfly88
 */

public class CalculatorEnum {
    enum Calculation{
        PLUS("+"){
            @Override
            public double Calculator(double a, double b){
                return a + b;
            }
        },
        MINUS("-"){
            @Override
            public double Calculator(double a, double b){
                return a - b;
            }
        },
        MULTIPLY("*"){
            @Override
            public double Calculator(double a, double b){
                return a * b;
            }
        },

        DIVIDE("/"){
            @Override
            public double Calculator(double a, double b){
                return a / b;
            }
        };

        final private String value;

        Calculation(String value) {
            this.value = value;
        }

        public String getValue(){
            return value;
        }

        public abstract double Calculator(double a, double b);

        // 연산값이 어떤거랑 매칭되는지 검증해주기
        public boolean matchingExpression(String value){
            return this.value.equals(value);
        }

    }

    public static String Calculation(Calculation cal, double x1, double x2) {
        return String.valueOf(cal.Calculator(x1, x2));
    }

    public static void main(String [] args){
        String a = "23  +   3";
        a = a.replaceAll(" ","");

        List stringList = new ArrayList<String>();
        for(int i=0 ; i<a.length(); i++){
            String getNum = new String(new char[] { a.charAt(i) }, 0, 1);
            stringList.add(getNum);
        }
        System.out.println(stringList);

//        for(int i=0; i<stringList.size(); i++){
//            System.out.println(stringList.get(i) + " /// " +stringList.get(i).equals(Calculation.PLUS.getValue()));
//
//        }

        try{
            double x=3;
            double y=5;
            String z="*";

            System.out.println("??? "+Calculation.valueOf("ABCD"));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
