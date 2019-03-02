package com.betterfly;

import com.betterfly.props.SpringProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by betterfly
 * Date : 2019.03.02
 */

@Component
public class ApplicationProperties implements ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(ApplicationProperties.class);

    @Autowired
    private String hello;

    @Autowired
    private SpringProperties properties;

    @Override
    public void run(ApplicationArguments args) {

        logger.info("LOG LEVEL : INFO");
        logger.error("LOG LEVEL : ERROR");
//        System.out.println(hello);
//        System.out.println(properties.getName());
//        System.out.println(properties.getFullName());
    }
}
