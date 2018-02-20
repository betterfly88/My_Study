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
        MINUS("\\-"){
            @Override
            public double Calculator(double a, double b){
                return a - b;
            }
        },
        MULTIPLY("\\*"){
            @Override
            public double Calculator(double a, double b){
                return a * b;
            }
        },
        DIVIDE("\\/"){
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
    }


    public static void main(String [] args){
        String a = "2  +   3";
        a = a.replaceAll(" ","");
//        String [] dd = a.split(Calculation.PLUS.getValue());

        List stringList = new ArrayList<String>();

        for(int i=0 ; i<a.length(); i++){
//            System.out.print(a.charAt(i));
            final String getNum = new String(new char[] { a.charAt(i) }, 0, 1);

            if(getNum.equals(Calculation.PLUS.getValue())){
                getNum.split(Calculation.PLUS.value);
                stringList.add(getNum);
                System.out.println("!?"+stringList);
            }
        }


//        for(String s : dd){
////            System.out.println(s);
//            s.replaceAll(" ","");
//            int temp = Integer.parseInt(s);
//            System.out.println(temp);
//        }
    }

}
