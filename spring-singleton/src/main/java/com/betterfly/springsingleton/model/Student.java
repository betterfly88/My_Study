package com.betterfly.springsingleton.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Scope("singleton")
@Component("student")
public class Student {
    private String name;
    private int age;
}
