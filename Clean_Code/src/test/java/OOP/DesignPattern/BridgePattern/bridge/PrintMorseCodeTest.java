package OOP.DesignPattern.BridgePattern.bridge;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by betterFLY on 2018. 3. 17.
 * Github : http://github.com/betterfly88
 */

public class PrintMorseCodeTest {
    ExcuteMorseCode morseCode;
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void 모스부호_출력(){
        System.out.println("프린트 실행");
        morseCode = new ExcuteMorseCode(new PrintMorseCode());
        morseCode.b().e().t().t().e().r().f().l().y();

        System.out.println("\n사운드 실행");

        morseCode = new ExcuteMorseCode(new SoundMorseCode());
        morseCode.b().e().t().t().e().r().f().l().y();
    }
}
