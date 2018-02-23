package dao;

/**
 * Created by betterFLY on 2018. 2. 24.
 * Github : http://github.com/betterfly88
 */

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;


public class CalculatorDaoTest {

    private CalculatorDao calculatorDao;

    @Before
    public void setUp(){
        System.out.println("initialized...");
        calculatorDao = new CalculatorDao();
    }

    @Test
    public void insertString(){

        String inputValue = "2 + 4 / 3";
        Assertions.assertThat(calculatorDao.executeCalculator()).isEqualTo(inputValue);
    }
}
