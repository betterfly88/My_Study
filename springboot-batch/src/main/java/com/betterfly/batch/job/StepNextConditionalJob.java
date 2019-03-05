package com.betterfly.batch.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 이충일 (betterfly@wemakeprice.com)
 * Date : 2019.03.05
 */

@Slf4j
@Configuration
@RequiredArgsConstructor
public class StepNextConditionalJob {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job setNExtConditionalJob(){
        return jobBuilderFactory.get("stepNextConditionalJob")
                .start(conditionalJob1()) // 최초 실행
                    .on("FAILED") // 결과가 FAILED 일때 (ExitStatus.FAILED)
                    .to(conditionalJob3()) // conditionalJob3() 실행
                    .on("*") // conditionalJob3() 의 결과가 상관없이 ( * : 전부 )
                    .end() // conditionalJob3() 후 종료
                .from(conditionalJob1()) // conditionalJob1() 리턴이
                    .on("*") // FAIL 외에 모든 경우 (위에 FAILED 일때가 있으니까)
                    .to(conditionalJob2()) // conditionalJob2() 실행
                    .next(conditionalJob3()) // conditionalJob2() 정상 종료 후 conditionalJob3() 실행
                    .on("*") // conditionalJob3() 결과 상관없이
                    .end() // 종료
                .end() // Job 종료
                .build();
    }

    @Bean
    public Step conditionalJob1() {
        return stepBuilderFactory.get("step1")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info(">> this is stepNextConditional Step - 1");
                    stepContribution.setExitStatus(ExitStatus.FAILED);
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step conditionalJob2() {
        return stepBuilderFactory.get("conditionalJobStep2")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info(">> this is stepNextConditional Step - 2");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step conditionalJob3() {
        return stepBuilderFactory.get("conditionalJobStep3")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info(">> this is stepNextConditional Step - 3");
                    return RepeatStatus.FINISHED;
                }).build();
    }
}
