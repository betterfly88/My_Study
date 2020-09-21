package com.betterfly.service;

import com.betterfly.domain.WhitePageConstructorProperties;
import com.betterfly.domain.WhitePageProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@RequiredArgsConstructor
public class WhitePageService {

    private final WhitePageProperties properties;
    private final WhitePageConstructorProperties conProperties;

    @PostConstruct
    public void openConnection() {
        log.info("Connecting address : {}", this.properties.getRemoteAddress());
        log.info("Security userName : {}, password : {}, roles : {}", this.properties.getSecurity().getUsername(), this.properties.getSecurity().getPassword(), this.properties.getSecurity().getRoles().toString());


        log.info("Connecting address : {}", this.conProperties.getRemoteAddress());
        log.info("Security userName : {}, password : {}, roles : {}", this.conProperties.getSecurity().getUsername(), this.conProperties.getSecurity().getPassword(), this.conProperties.getSecurity().getRoles().toString());
    }
}
