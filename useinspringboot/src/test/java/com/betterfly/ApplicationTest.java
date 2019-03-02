package com.betterfly;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * Created by betterfly
 * Date : 2019.03.02
 */

@RunWith(SpringRunner.class)
@TestPropertySource(locations ="classpath:/test.properties")
@SpringBootTest
public class ApplicationTest {

    @Autowired
    Environment env;

    @Test
    public void test(){
        assertThat(env.getProperty("betterfly.age"))
                .isEqualTo("15");
        assertThat(env.getProperty("betterfly.name"))
                .isEqualTo("test.chungil2");
    }
}
