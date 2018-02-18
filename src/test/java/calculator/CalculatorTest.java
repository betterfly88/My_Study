package calculator;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by betterFLY on 2018. 2. 18.
 * Github : http://github.com/betterfly88
 */

public class CalculatorTest{

    Calculator cal;

    @Before
    public void setUp(){
        System.out.println("setUp");
        cal = new Calculator();
    }

    @Test
    public void 덧셈() {
//        calculator.Calculator cal = new calculator.Calculator();
        System.out.println("덧셈");
        Assert.assertEquals(6, cal.sum(2, 4)); // 단일 메서드로 종료
        Assertions.assertThat(cal.sum(2,4)).isEqualTo(6);   // 체인방식으로 뒤에 계속 다른 결과를 확인해볼 수 있음
//        assertThat(cal.sum(2,4)).isEqualTo(8);   // 체인방식으로 뒤에 계속 다른 결과를 확인해볼 수 있음
    }

    @Test
    public void 뺄셈(){
//        calculator.Calculator cal = new calculator.Calculator();
        System.out.println("뺄셈");
        Assertions.assertThat(cal.minus(10,4)).isEqualTo(6);   // 체인방식으로 뒤에 계속 다른 결과를 확인해볼 수 있음
    }
}
