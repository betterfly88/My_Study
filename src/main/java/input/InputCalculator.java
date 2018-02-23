package input;

import service.CalculatorHandler;

import java.util.Scanner;

/**
 * Created by betterFLY on 2018. 2. 18.
 * Github : http://github.com/betterfly88
 */

public class InputCalculator {

    static CalculatorHandler handler;

    public static double executeCalculator(){
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();

        return handler.resultCalculator(value);
    }
}