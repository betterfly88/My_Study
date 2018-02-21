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

        private final String operator;

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

        public boolean matchedExpression(String value){
            return this.operator.equals(value);
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

        ArrayList<String> arrayList = splitValue("24 + 4");
        //배열에 수식이 있는 경우 [-1 0 +1]  이기 때문에, 0 기준 [-1 연산 +1]
        /**
         * 배열 사이즈만큼 재귀함수 돌려서 숫자/연산자 체크해서 계산하면 될까?
         */
        for(int i=0; i<arrayList.size(); i++){
//            Calculate.matchedExpression(arrayList.get(i));
        }
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