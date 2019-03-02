package com.betterfly.props;

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

    @Autowired
    SpringProperties props;

//    @Value("${betterfly.name}")
//    private String name;
//
//    @Value("${betterfly.age}")
//    private int age;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("Name : "+props.getName());
        System.out.println("Age : "+props.getAge());
        System.out.println("full Name : "+props.getFullName());
    }
}
