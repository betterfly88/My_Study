package com.betterfly.objectmapping.service;

import com.betterfly.objectmapping.converter.OrikaConverterImpl;
import com.betterfly.objectmapping.entity.OrderEntity;
import com.betterfly.objectmapping.model.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrikaServiceImpl extends AbstractMappingService{
    private OrikaConverterImpl orikaConverter;

    public OrikaServiceImpl(){
        orikaConverter = new OrikaConverterImpl();
    }

    @Override
    public List<OrderEntity> converter(List<OrderDto> list) {
        return list.stream()
                .map(orikaConverter::convertDtoToEntity)
                .collect(Collectors.toList());
    }
}
