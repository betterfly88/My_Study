package common;

/**
 * Created by betterFLY on 2018. 2. 24.
 * Github : http://github.com/betterfly88
 */


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {

    Utils utils;

    @Before
    public void setUp(){
        System.out.println("initialized...");
        utils = new Utils();
    }

    @Test
    public void String_to_Double_Parsing(){
        Assertions.assertThat(utils.parseDouble("10.5")).isEqualTo(10.5);
    }

    @Test
    public void String_split_addArray(){
        String temp = "10 + 2 - 6 * 3 / 2";
        Assertions.assertThat(utils.splitValue(temp)).contains("10").contains("/");

    }
}
