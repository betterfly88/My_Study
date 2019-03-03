package com.betterfly.controller;

import com.betterfly.service.SampleService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by betterfly
 * Date : 2019.03.03
 */

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerSliceTest {
    // https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html
    @MockBean
    SampleService service;

    @Autowired
    MockMvc mockMvc;

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void hello() throws Exception{
        when(service.getName()).thenReturn("betterFLY");

        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hello~~ betterFLY"));

        assertThat(outputCapture.toString())
                .contains("logging Test")
                .contains("println");
    }
}
