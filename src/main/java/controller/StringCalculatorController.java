package controller;

import dao.CalculatorDao;
import handler.CalculatorHandler;

import java.util.Calendar;

/**
 * Created by betterFLY on 2018. 2. 18.
 * Github : http://github.com/betterfly88
 */

public class StringCalculatorController {

    static CalculatorHandler handler;

    public static void main(String[] args) {
//        double result = CalculatorDao.executeCalculator();
        try{
            double result = handler.resultCalculator(CalculatorDao.executeCalculator());
            System.out.println("결과 : "+result);
        }catch (NumberFormatException e){
            System.out.println("Error cause : "+e.getMessage());
            System.out.println("숫자 또는 연사자만 입력해주세요.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

/*
    개선점
    1. 에외처리
        - 숫자 이외의 값 입력 예외 처리
        - Q. 예외처리할때 실제 문제가 발생하는 메서드가 아니라 메인에서 try~catch 처리하면 다 되는데,
        - throw, throws 등으로 메서드에 선언을 하는 이유? >> 어차피 throw만 한다고 해결안되는데..
        >> 각 메서드에서 try catch 를 일일히 수행하면 코드가 더러워지니까 throws로 메인에 던져서 한번에 처리??
    2. 패키지 구조
        - 현재 구조가 모호함.
        - 정확한 기준으로 구조 나누기
    3. 똑똑한 계산기
        - 현재 " "(공백)으로 문자열 Split함
        - 선언한 연산자 (+,-,+,/) 기준으로 split 구현
 */