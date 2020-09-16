package com.betterfly.annotation;

import com.betterfly.annotation.service.Moja;
import com.betterfly.annotation.service.MojaFactory;

import java.time.ZonedDateTime;

public class App {
    public static void main(String[] args) {
        Moja moja = new MojaFactory();
    }
}
