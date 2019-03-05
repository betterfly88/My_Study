package com.betterfly.batch.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 이충일 (betterfly@wemakeprice.com)
 * Date : 2019.03.05
 */

@Slf4j
@RequiredArgsConstructor
@Configuration
public class JobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job jobTask(){
        return jobBuilderFactory.get("job_task")
                .start(taskStep1(null))
                .next(taskStep2(null))
                .build();
    }

    @Bean
    @JobScope
    public Step taskStep1(@Value("#{jobParameters[requestDate]}") String requestDate){
        return stepBuilderFactory.get("taskStep1")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info(">> start task step 1");
                    log.info(">> requestDate : {}", requestDate);
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    @JobScope
    public Step taskStep2(@Value("#{jobParameters[requestDate]}") String requestDate){
        return stepBuilderFactory.get("taskStep2")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info(">> start task step 2");
                    log.info(">> requestDate : {}", requestDate);
                    return RepeatStatus.FINISHED;
                }).build();
    }
}
