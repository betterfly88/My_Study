package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by betterFLY on 2018. 2. 22.
 * Github : http://github.com/betterfly88
 */

public class CalculatorHandler {

    private enum Calculate implements CalculatorService{
        PLUS("+"){
            @Override
            public double Calculator(double a, double b) {
                return a+b;
            }
        },

        MINUS("-"){
            @Override
            public double Calculator(double a, double b) {
                return a-b;
            }
        },

        MULTIPLY("*") {
            @Override
            public double Calculator(double a, double b) {
                return a * b;
            }
        },

        DIVIDE("/"){
            @Override
            public double Calculator(double a, double b) {
                return a / b;
            }
        };

        private String operator;

        Calculate(String operator) {
            this.operator = operator;
        }

        public String getOperator(){
            return this.operator;
        }

        private static Map<String, Calculate> requestMapping;

        static {
            requestMapping = new HashMap<String, Calculate>();
            requestMapping.put(PLUS.getOperator(), PLUS);
            requestMapping.put(MINUS.getOperator(), MINUS);
            requestMapping.put(MULTIPLY.getOperator(), MULTIPLY);
            requestMapping.put(DIVIDE.getOperator(), DIVIDE);
        }

        public static Calculate operatorCheck(String operator) {
            return requestMapping.get(operator);
        }
    }


    public double invokeCalculator(String operator, double a, double b) {
        Calculate operation = Calculate.operatorCheck(operator);

        return operation.Calculator(a,b);
    }

    public static void main (String [] args){
        CalculatorHandler cal = new CalculatorHandler();
//        System.out.println(cal.invokeCalculator("*",1,5));
//        System.out.println(cal.invokeCalculator("/",6,3));

        ArrayList arrayList = splitValue("24 + 4");

        System.out.println(arrayList);
    }

    public static ArrayList<String> splitValue(String value){
        ArrayList arrStr = new ArrayList<String>();
        String [] temp = value.split(" ");
        for(int i=0; i<temp.length; i++){
            arrStr.add(temp[i]);
        }
        return arrStr;
    }
}