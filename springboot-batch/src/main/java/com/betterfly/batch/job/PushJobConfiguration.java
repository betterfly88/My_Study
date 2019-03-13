package com.betterfly.batch.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by betterfly
 * Date : 2019.03.11
 */
@RequiredArgsConstructor
@Configuration
public class PushJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private static final int CORE_TASK_POOL_SIZE = 24;
    private static final int MAX_TASK_POOL_SIZE = 128;
    private static final int CHUNK_SIZE = 400;

    @Bean(name = "pushJobTaskPool")
    public TaskExecutor executor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(CORE_TASK_POOL_SIZE);
        taskExecutor.setMaxPoolSize(MAX_TASK_POOL_SIZE);

        return taskExecutor;
    }

//    @Bean(name="pushStep")
//    public Step step(){
//        return stepBuilderFactory.get("pushStep")
//                .<String, String>chunk(CHUNK_SIZE)
//                .reader()
//                .processor()
//                .writer()
//                .taskExecutor(executor())
//                .build();
//    }
}
