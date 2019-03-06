package com.betterfly.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by betterfly
 * Date : 2019.03.05
 */

@SpringBootApplication
@EnableBatchProcessing
public class BatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }
}

// https://medium.com/cashwalk/springboot-mybatis-gradle-mysql-7090359d5427
/**
 * Spring boot - Basic
 * 기본 흐름 : 읽기(Read) - 처리(Processing) - 쓰기(Write)
 * 읽기 : 데이터 저장소(대상)에서 특정 레코드를 읽는다.
 * 처리 : 원하는 방식으로 데이터 가공/처리
 * 쓰기 : 수정된 데이터를 다시 저장소에 저장
 *
 * Job - Step : 1:N
 * Step - [ItemReader, ItemProcessor, ItemWriter] : 1:1
 * -> Job이라는 하나의 일감에 여러 단계(Step)을 두고, 각 배치를 구성함
 * https://cheese10yun.github.io/spring-batch-basic/
 * */
