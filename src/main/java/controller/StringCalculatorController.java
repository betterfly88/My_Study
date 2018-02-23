package controller;

import dao.CalculatorDao;
import handler.CalculatorHandler;

/**
 * Created by betterFLY on 2018. 2. 18.
 * Github : http://github.com/betterfly88
 */

public class StringCalculatorController {

    static CalculatorHandler handler;

    public static void main(String[] args) {
//        double result = CalculatorDao.executeCalculator();

        double result = handler.resultCalculator(CalculatorDao.executeCalculator());
        System.out.println("결과 : "+result);
    }
}