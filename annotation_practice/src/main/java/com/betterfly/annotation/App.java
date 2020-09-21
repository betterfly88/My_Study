package com.betterfly.annotation;

import com.betterfly.annotation.service.Moja;
import com.betterfly.annotation.service.MojaFactory;

public class App {
    public static void main(String[] args) {
        Moja moja = new MojaFactory();
        System.out.println(moja.pullOut());;
    }
}
