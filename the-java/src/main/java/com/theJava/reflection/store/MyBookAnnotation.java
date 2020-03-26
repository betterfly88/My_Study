package com.theJava.reflection.store;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Inherited
public @interface MyBookAnnotation {
    String value();
    String name() default "emtpy";
    int age() default 0;
}
