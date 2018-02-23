package service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by betterFLY on 2018. 2. 24.
 * Github : http://github.com/betterfly88
 */

public class CalculatorServiceImpl {
    public enum Calculate implements CalculatorService{
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

        // 연산자 추출
        public static Calculate operatorCheck(String operator) {
            return requestMapping.get(operator);
        }

        // 걊 존재 유무체크
        public static boolean matchedExpression(String operator) {
            return requestMapping.containsKey(operator);
        }
    }
}
