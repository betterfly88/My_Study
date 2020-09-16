package com.betterfly.config;

import com.betterfly.domain.WhitePageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(WhitePageProperties.class)
public class BindingConfiguration {

    @Bean
    public void bindingTest(){

    }
}
