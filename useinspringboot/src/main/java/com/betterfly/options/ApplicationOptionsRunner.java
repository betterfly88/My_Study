package com.betterfly.options;

import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by betterfly
 * Date : 2019.03.02
 */
@Component
@Order(1)
public class ApplicationOptionsRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println(args.containsOption("bar"));
    }
}