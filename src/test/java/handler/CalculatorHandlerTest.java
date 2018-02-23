package handler;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by betterFLY on 2018. 2. 24.
 * Github : http://github.com/betterfly88
 */

public class CalculatorHandlerTest {

    CalculatorHandler handler;
    @Before
    public void setUp(){
        System.out.println("setUp");
        handler = new CalculatorHandler();
    }

    @Test
    public void 계산기_실행(){
        Assertions.assertThat(handler.invokeCalculator("*", 4,20)).isEqualTo(80.0);
    }

    @Test
    public void 최종_계산기(){
        Assertions.assertThat(handler.resultCalculator("2 + 4 * 4 - 12")).isEqualTo(12.0);
    }
}
