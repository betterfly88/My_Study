package com.betterfly.objectmapping.service;

import com.betterfly.objectmapping.converter.ModelMapperConverterImpl;
import com.betterfly.objectmapping.entity.OrderEntity;
import com.betterfly.objectmapping.model.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

public class ModelMapperServiceImpl extends AbstractMappingService{
    private ModelMapperConverterImpl modelMapperConverter;

    public ModelMapperServiceImpl(){
        modelMapperConverter = new ModelMapperConverterImpl();
    }

    @Override
    public List<OrderEntity> converter(List<OrderDto> list) {
        return list.stream()
                .map(modelMapperConverter::convertDtoToEntity)
                .collect(Collectors.toList());
    }
}
