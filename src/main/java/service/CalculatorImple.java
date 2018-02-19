package service;

/**
 * Created by betterFLY on 2018. 2. 19.
 * Github : http://github.com/betterfly88
 */

public class CalculatorImple implements Calculator{

    @Override
    public double ADDITION(double a, double b) {
        return a+b;
    }

    @Override
    public double SUBTRACTION(double a, double b) {
        return a-b;
    }

    @Override
    public double MULTIPLICATION(double a, double b) {
        return a*b;
    }

    @Override
    public double DIVISION(double a, double b) {
        return a/b;
    }
}
