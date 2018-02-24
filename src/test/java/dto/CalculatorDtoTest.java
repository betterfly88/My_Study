package dto;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by betterFLY on 2018. 2. 24.
 * Github : http://github.com/betterfly88
 */

public class CalculatorDtoTest {

    CalculatorDto dto;

    @Before
    public void setUp(){
        System.out.println("initialized...");
        dto = new CalculatorDto();
    }

    @Test
    public void 연산자입력후_결과예측(){

//        Assertions.assertThat(CalculatorDto.Calculate.valueOf("PLUS")).isEqualTo(PLUS);
        Assertions.assertThat(CalculatorDto.Calculate.PLUS.getOperator()).isEqualTo("+");
        Assertions.assertThat(CalculatorDto.Calculate.matchingExpression("+")).isEqualTo(true);
        Assertions.assertThat(CalculatorDto.Calculate.matchingExpression("^")).isEqualTo(false);

        Assertions.assertThat(CalculatorDto.Calculate.operatorCheck("+")).isEqualTo(CalculatorDto.Calculate.PLUS);
        Assertions.assertThat(CalculatorDto.Calculate.PLUS.Calculator(4, 5)).isEqualTo(9.0);

    }
}
