package net.class101.server1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class HomeworkApplication {
    public static void main(String[] args)  {
        SpringApplication.run(HomeworkApplication.class, args);
    }
}