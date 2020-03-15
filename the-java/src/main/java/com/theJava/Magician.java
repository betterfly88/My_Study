package com.theJava;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Magician {
    public static void main(String[] args) throws IOException {
        new ByteBuddy().redefine(Hat.class)
                .method(named("pullOut")).intercept(FixedValue.value("Rabbit"))
                .make().saveIn(new File("/Users/betterfly/dev/repository/my-study/My_Study/the-java/target/classes/"));
        ;
    }
}
