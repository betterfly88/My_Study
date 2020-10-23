package com.betterfly.objectmapping.service;

import com.betterfly.objectmapping.entity.OrderEntity;
import com.betterfly.objectmapping.mapper.MapStructConverter;
import com.betterfly.objectmapping.model.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

public class MapStructServiceImpl extends AbstractMappingService{

    @Override
    public List<OrderEntity> converter(List<OrderDto> list) {
        return list.stream()
                .map(MapStructConverter.INSTANCE::convertDtoToEntity)
                .collect(Collectors.toList());
    }
}
