package com.betterfly.objectmapping.mapper;

import com.betterfly.objectmapping.entity.OrderEntity;
import com.betterfly.objectmapping.model.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.factory.Mappers;

/*
    https://www.baeldung.com/mapstruct
 */
@Mapper
public interface MapStructConverter extends Converter {
    MapStructConverter INSTANCE = Mappers.getMapper(MapStructConverter.class);

    @Mapping(source = "status", target="orderStatus")
    @Override
    OrderEntity convertDtoToEntity(OrderDto orderDto);
}
