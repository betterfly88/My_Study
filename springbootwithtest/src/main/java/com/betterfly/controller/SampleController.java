package com.betterfly.controller;

import com.betterfly.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by betterfly
 * Date : 2019.03.03
 */
@RestController
public class SampleController {
    Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SampleService service;

    @GetMapping("/hello")
    public String hello(){
        logger.info("logging Test");
        System.out.println("println");

        return "hello~~ " + service.getName();

    }
}
