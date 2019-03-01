package com.betterfly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by betterfly
 * Date : 2019.03.01
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        String [] arg = new String[1];
        arg[0] = "--debug";
        app.run(arg);
    }
}
