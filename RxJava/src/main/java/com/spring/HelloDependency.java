package com.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public class HelloDependency {

    private final StringPrinter printer;

    public void printMessage(String msg){
        printer.print(msg);
    }
}
