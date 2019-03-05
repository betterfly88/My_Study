package com.betterfly.batch.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 이충일 (betterfly@wemakeprice.com)
 * Date : 2019.03.05
 */

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ScopeJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job scopeJob(){
        return jobBuilderFactory.get("scopeJob")
                .start(scopeStep2())
//                .next(scopeStep2())
                .build();
    }

    @Bean
    @JobScope
    public Step scopeStep1(
            @Value("#{jobParameters[requestDate]}") String requestDate){
        return stepBuilderFactory.get("scopeStep1")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info(">> This is scopeStep - 1");
                    log.info(">> requestDate : {}", requestDate);
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step scopeStep2() {
        return stepBuilderFactory.get("scopeStep2")
                .tasklet(scopeStep2Tasklet(null))
                .build();

    }

    @Bean
    @StepScope
    public Tasklet scopeStep2Tasklet(
            @Value("#{jobParameters[requestDate]}")String requestDate) {
        return ((stepContribution, chunkContext) -> {
            log.info(">>> This is scope Stpe - 2");
            log.info(">>> RequestDate = {}", requestDate);
            return RepeatStatus.FINISHED;
        });
    }
}
