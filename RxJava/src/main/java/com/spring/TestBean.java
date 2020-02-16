package com.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestBean {

    private final TestB test;

    @Bean
    public void asdf(){
        System.out.println("Test Bean Loading");
    }
}
