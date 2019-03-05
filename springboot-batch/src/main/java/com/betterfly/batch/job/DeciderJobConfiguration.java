package com.betterfly.batch.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * Created by 이충일 (betterfly@wemakeprice.com)
 * Date : 2019.03.05
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class DeciderJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job deciderJob() {
        return jobBuilderFactory.get("deciderJob")
                .start(startStep())
                .next(decider()) // start 이후 실행자
                .from(decider()) // event listener 역할 > decider의 리턴값이
                    .on("ODD") // ODD 일때
                    .to(oddStep()) // oddStep() 실행
                .from(decider()) // decider 리턴이
                    .on("EVEN")  // EVENT 일때
                    .to(eventStep())  // eventStep() 실행
                .end() // 종료
                .build();
    }

    @Bean
    public Step startStep() {
        return stepBuilderFactory.get("startStep")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info(">>> Decider Start !");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step oddStep() {
        return stepBuilderFactory.get("oddStep")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info(">>> ODD VALUE !!! ");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step eventStep() {
        return stepBuilderFactory.get("eventStep")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info(">>> EVENT VALUE !!! ");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public JobExecutionDecider decider() {
        return new OddDecider();
    }

    public static class OddDecider implements JobExecutionDecider{

        @Override
        public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
            Random r = new Random();

            int randomNum = r.nextInt(50) + 1;
            log.info("random Number : {}", randomNum);

            if (randomNum % 2 == 0) {
                return new FlowExecutionStatus("EVEN");
            }else {
                return new FlowExecutionStatus("ODD");
            }
        }
    }
}
