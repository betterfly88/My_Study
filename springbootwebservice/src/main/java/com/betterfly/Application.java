package com.betterfly;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by betterfly
 * Date : 2019.02.24
 */

@SpringBootApplication
@RestController
public class Application {
    @GetMapping("/")
    public String main(){
        return "hello betterFly's World";
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
