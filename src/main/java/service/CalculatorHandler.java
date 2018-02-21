package service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by betterFLY on 2018. 2. 22.
 * Github : http://github.com/betterfly88
 */

public class CalculatorHandler {

    private interface calOperator{
        double Calculator(double a, double b);
    }

    private enum Calculate implements calOperator{

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
        System.out.println(cal.invokeCalculator("*",1,5));
    }
}