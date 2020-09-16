package com.betterfly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan({ "com.betterfly.domain"})
public class WhitePageApplication {
    public static void main(String[] args) {
        SpringApplication.run(WhitePageApplication.class);
    }

}
