package controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by betterFLY on 2018. 2. 18.
 * Github : http://github.com/betterfly88
 */

public class StringCalculatorControllerTest {
    /*
        1) 기능 요구 사항
            사용자가 입력한 문자열에 따라 사칙 연산을 수행하는 계산기 구현.
            사칙 연산의 연산자 우선 순위가 아닌 입력 순서에 따라 계산한다. (ex) 2 + 3 * 2 -> 10)
        2) 프로그래밍 요구 사항
            한 메서드에 오직 한 단계의 들여쓰기만 할 것
            else 키워드를 사용하지 말 것
        3) 추가 요구 사항(선택 사항)
            사칙 연산을 구현하면 4개의 if문을 사용하는 코드가 발생하는데, 자바의 다형성을 이용하여 if문을 모두 제거해볼 것.
    */
    StringCalculatorController sc;

    @Before
    public void setUp(){
        sc = new StringCalculatorController();
    }

    @Test
    public void 순서대로_연산() {

    }
}
