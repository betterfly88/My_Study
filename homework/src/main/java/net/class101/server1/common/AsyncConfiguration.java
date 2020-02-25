package net.class101.server1.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
@Slf4j
public class AsyncConfiguration implements AsyncConfigurer {

    @Bean
    public Executor orderTaskExecutor() {
        int runningThreadCounts =Runtime.getRuntime().availableProcessors();
        log.info("running thread counts : {}", runningThreadCounts);

        return Executors.newFixedThreadPool(runningThreadCounts);
    }
}