package com.betterfly.springbootmvc.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by betterfly
 * Date : 2019.03.03
 */

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void createUser_JSON() throws Exception {
        String userJson = "{\"userName\" : \"chungil\", \"userId\" : \"betterfly\" }";

        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(userJson))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.userName"
                            , is(equalTo("chungil"))))
                    .andExpect(jsonPath("$.userId"
                            , is(equalTo("betterfly"))));
    }

    @Test
    public void createUser_XML() throws Exception {
        String userJson = "{\"userName\" : \"chungil\", \"userId\" : \"betterfly\" }";

        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_XML)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/userName")
                        .string("chungil"))
                .andExpect(xpath("/User/userId")
                        .string("betterfly"));
    }
}
