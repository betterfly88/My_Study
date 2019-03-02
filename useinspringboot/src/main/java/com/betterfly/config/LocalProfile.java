package com.betterfly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by betterfly
 * Date : 2019.03.03
 */

@Profile("local")
@Configuration
public class LocalProfile {

    @Bean
    public String hello(){
        return "Local HELLO";
    }
}
