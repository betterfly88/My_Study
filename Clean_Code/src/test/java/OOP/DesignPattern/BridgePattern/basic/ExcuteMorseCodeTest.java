package OOP.DesignPattern.BridgePattern.basic;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by betterFLY on 2018. 3. 17.
 * Github : http://github.com/betterfly88
 */

public class ExcuteMorseCodeTest {
    PrintMorseCode morseCode;
    @Before
    public void setUp() throws Exception {
        morseCode = new PrintMorseCode();
    }

    @Test
    public void 모스부호_출력(){

        morseCode.b(); morseCode.e();morseCode.t();morseCode.t();morseCode.e(); morseCode.r();morseCode.f();morseCode.l();morseCode.y();

        /*
            각 함수를 void로 사용하면 이처럼 사용해야하지만, 해당 클래스를 리턴해서 체인방식으로 구현할 수 있다
         */
        System.out.println("\n체인방식");
        morseCode.b().e().t().t().e().r().f().l().y();
    }
}
