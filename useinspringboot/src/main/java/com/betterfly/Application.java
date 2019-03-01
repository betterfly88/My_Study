package com.betterfly;

import com.betterfly.listener.BootListener;
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
        app.addListeners(new BootListener());
        app.run(args);
    }
}
