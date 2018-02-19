package service;

/**
 * Created by betterFLY on 2018. 2. 19.
 * Github : http://github.com/betterfly88
 */

public class CalculatorEnum {
    enum Calculation{
        PLUS("+"){
            public double calcualtor(double a, double b){
                return a + b;
            }
        }
                ;
//        MINUS("-"),
//        MULTIPLY("*"),
//        DIVIDE("/");

        final private String value;

        Calculation(String value) {
            this.value = value;
        }

        public String getValue(){
            return value;
        }
    }

    public static void main(String [] args){
        System.out.println("이거 뭐임 ?"+Calculation.PLUS.getValue());
        System.out.println(Calculation.PLUS);
    }
}
