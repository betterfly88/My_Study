package com.betterfly.batch.job;

import com.betterfly.batch.step.BigQueryPagingItemReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by 이충일 (betterfly@wemakeprice.com)
 * Date : 2019.03.06
 */

@Slf4j
@Configuration
@RequiredArgsConstructor
public class PushReceiveJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

//    @Autowired
//    private BigQueryClient bigQueryClient;
    private Map<String, Integer> pushMap;

    private static final int CHUNK_SIZE = 10;
    private static final int CORE_TASK_POOL_SIZE = 8;
    private static final int MAX_TASK_POOL_SIZE = 12;


    @Bean
    public TaskExecutor executor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(CORE_TASK_POOL_SIZE);
        taskExecutor.setMaxPoolSize(MAX_TASK_POOL_SIZE);

        return taskExecutor;
    }


    @Bean
    public Job pushReceiveJob(){
        return jobBuilderFactory.get("pushReceiveJob")
                .start(getBigQueryStep(null))
                    .on("FAILED")
                    .end()
                .from(getBigQueryStep(null))
                    .on("*")
                    .to(insertBatchResultStep())
                    .end()
                .build();
    }

    @Bean
    @JobScope
    public Step getBigQueryStep(
            @Value("#{jobParameters[requestDate]}") String requestDate) throws IllegalStateException{
        return stepBuilderFactory.get("bigQueryStep")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info(">> Push Receive Step Start : {}", requestDate);

//                    pushMap = bigQueryClient
//                            .startDate(requestDate)
//                            .build();

                    if (pushMap.isEmpty()){
                        stepContribution.setExitStatus(ExitStatus.FAILED);
                    }
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    @JobScope
    public Step insertBatchResultStep() throws IllegalStateException{
        return stepBuilderFactory.get("insertBatchResultStep")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info(">> insert Batch Result Step ");

                    for (String s : pushMap.keySet()){
                        System.out.println(s);
                    }
                    return RepeatStatus.FINISHED;
                }).build();
    }


    @Bean
    @JobScope
    public Step pushReceiveStep(
            @Value("#{jobParameters[requestDate]}") String requestDate){
        return stepBuilderFactory.get("pushReceiveStep")
                .<String, String> chunk(CHUNK_SIZE)
                .reader(bigQueryItemReader(requestDate)) //bigquery 결과(detail) string return
                .processor(bigQueryItemProcessor()) // json 화 시켜서 PushReceiveVO 맵핑
                .writer(bigQueryItemWriter()) // mysql에 카운팅
                .taskExecutor(executor())
                .build();
    }

    @Bean
    @StepScope
    public BigQueryPagingItemReader<String> bigQueryItemReader(
            @Value("#{jobParameters[requestDate]}") String requestDate) {

        JdbcPagingItemReader aa = new JdbcPagingItemReader();

        return new BigQueryPagingItemReader<String>()
                .fetchSize(1000)
                .requestDate(requestDate)
                .build();
    }

    @Bean
    @StepScope
    public ItemProcessor<String, String> bigQueryItemProcessor(){
        return new ItemProcessor<String, String>() {

            @Override
            public String process(String item) throws Exception {
                return item;
            }
        };
    }

    @Bean
    @StepScope
    public ItemWriter<String> bigQueryItemWriter(){
        return new ItemWriter<String>() {
            @Override
            public void write(List<? extends String> list) throws Exception {
                for(String a : list){
                    log.info("item writer...{}", a);
                }
            }
        };
    }

    private final DataSource ds;

    @Bean
    public JdbcBatchItemWriter<String> jdbcBatchItemWriter(){
        return new JdbcBatchItemWriterBuilder<String>()
                .dataSource(ds)
                .sql("update")
                .beanMapped()
                .build();
    }
}
