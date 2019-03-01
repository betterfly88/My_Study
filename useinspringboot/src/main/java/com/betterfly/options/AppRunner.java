package com.betterfly.options;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by betterfly
 * Date : 2019.03.02
 */

@Component
@Order(2)
public class AppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("AFTER RUNNER...");
        System.out.println("is contained 'bar' : "+args.containsOption("bar"));
    }
}
