package com.betterfly;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by betterfly
 * Date : 2019.02.24
 */
@Configuration
@EnableConfigurationProperties(BookProperties.class)
public class BookConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Book book(BookProperties properties){
        Book b  = new Book();
        b.setTitle(properties.getTitle());
        b.setSerial(properties.getSerial());

        return b;
    }
}
