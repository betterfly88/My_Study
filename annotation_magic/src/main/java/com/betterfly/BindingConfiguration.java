package com.betterfly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.beans.BeanProperty;

@Component
public class BindingConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public void asdf(){

//        Binder.get(env.getActiveProfiles())
//                .bind
    }
}
