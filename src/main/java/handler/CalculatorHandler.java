package handler;

import common.Utils;
import dto.CalculatorDto;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;

/**
 * Created by betterFLY on 2018. 2. 22.
 * Github : http://github.com/betterfly88
 */

public class CalculatorHandler{

    private static CalculatorDto.Calculate calcuate;
    private static Utils utils;

    // 중간 연산
    public static double invokeCalculator(String operator, double a, double b) {
        CalculatorDto.Calculate operation = CalculatorDto.Calculate.operatorCheck(operator);
        return operation.Calculator(a,b);
    }

    // 최종 연산
    public static double resultCalculator (String inputValue){
        CalculatorHandler calHandler = new CalculatorHandler();
        ArrayList<String> arrayList = utils.splitValue(inputValue);

        //배열에 수식이 있는 경우 [-1 0 +1]  이기 때문에, 0 기준 [-1 연산 +1]
        double result = parseDouble(arrayList.get(0));
        for(int i=0; i<arrayList.size(); i++){
            if(calcuate.matchingExpression(arrayList.get(i))){
                result = calHandler.invokeCalculator(arrayList.get(i),result,parseDouble(arrayList.get(i+1)));
            }
        }
        return result;
    }
}