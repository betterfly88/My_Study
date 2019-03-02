package com.betterfly;

import com.sun.javafx.binding.Logging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by betterfly
 * Date : 2019.03.01
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Application.class);
//        app.addListeners(new BootListener());
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
}
