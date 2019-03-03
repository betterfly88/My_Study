package com.betterfly.springbootmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by betterfly
 * Date : 2019.03.03
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m/**")
                .addResourceLocations("classpath:/m/") // 마지막에 / 꼭 붙여줘야함.
                .setCachePeriod(20); // 캐싱 전략을 따로 설정해야함.
    }
}
