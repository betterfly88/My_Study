package com.betterfly.controller;

import com.betterfly.service.SampleService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by betterfly
 * Date : 2019.03.03
 */

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
/*
dispatcher-servlet 역할을 하는 MOCK
 */
public class SampleControllerTest {
    /*
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
    MOCK 환경에서 테스트 하는 방법
     */

//    @Autowired
//    MockMvc mockMvc;
//


//    @Test
//    public void hello() throws Exception{
//        mockMvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("hello~~ chungil"))
//                .andDo(print());
//
//
//    }

    /*
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    Random PORT를 이용한 테스트 방법
    Test용 Rest Template이나 테스트 용 웹 클라이언트를 사용해서 사용해야함 (MOCK 사용 X)
     */


    @Autowired
    TestRestTemplate template;

    @Test
    public void template_hello(){
//        String result = template.getForObject("/hello", String.class);
//        assertThat(result).isEqualTo("hello~~ chungil");


    }

    /*
    위 두가지에서 문제는 테스트가 너무 무겁다.
    @Service까지 가서 가져오는 것 자체가 부담된다.
    @Controller 정도에서만 테스트를 진행하고 싶다면...?

    이 방법은 실제로 @Service에 접근하는 것이 아닌, Mocking만 하여 실제 존재하고 타입이 같으면 내가 임의로 지정한 값으로 테스트할 수 있도록 해준다...?
    @MockBean
    SampleController mockSampleController;
     */

    @MockBean
    SampleService mockSampleService;

    @Test
    public void mock_hello(){
        when(mockSampleService.getName()).thenReturn("betterfly");

        String result = template.getForObject("/hello", String.class);
        assertThat(result).isEqualTo("hello~~ betterfly");
    }


    /*
    Async 비동기로 call

     */
    @Autowired
    WebTestClient webTestClient;

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testClient_hello(){
        when(mockSampleService.getName()).thenReturn("betterfly_client");

        webTestClient.get().uri("/hello").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hello~~ betterfly_client");

                assertThat(outputCapture.toString())
                .contains("logging Test")
                .contains("println");
    }

    /*
    MOCK이라는 웹환경 설정은 Mocking한 DispatcherServlet을 사용해서 테스트 하겠다는 것일뿐이고 그게 기본값이라 딱히 저렇게 설정하지 않아도 됩니다. 그럴때는 테스트를 MockMvc로 작성하면 되구요.

    저거 말고 다른 두개가 더 있는데, 그것들로 설정하면 실제 테스트용 톰캣이 가동되기 때문에 그때부턴 RestTemplate이나 WebTestClient로 테스트를 짜야합니다.

    지금까지 @SpringBootTest 어노테이션은
    메인 클래스 @SpringBootApplication 을 찾아서 연관된 모든 빈을 스캔해서 테스트하는
    굉장히 큰 단위의 통합테스트임

    하지만 난 내가 테스트하고 싶은 것만 테스트 하고 싶다면...?
     */
}