package com.betterfly.objectmapping.service;

import com.betterfly.objectmapping.entity.OrderEntity;
import com.betterfly.objectmapping.model.OrderDto;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class AbstractMappingService {
    public void execute(List<OrderDto> list){
        long start = System.currentTimeMillis();

        converter(list);

        double secDiffTime = (System.currentTimeMillis() - start)/1000.0;
        log.info("실행시간(s), {}", secDiffTime);
    }

    abstract List<OrderEntity> converter(List<OrderDto> list);
}
