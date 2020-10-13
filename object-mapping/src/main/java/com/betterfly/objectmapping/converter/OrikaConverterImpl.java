package com.betterfly.objectmapping.converter;

import com.betterfly.objectmapping.entity.OrderEntity;
import com.betterfly.objectmapping.mapper.Converter;
import com.betterfly.objectmapping.model.OrderDto;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaConverterImpl implements Converter {

    private MapperFacade mapperFacade;

    public OrikaConverterImpl() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(OrderDto.class, OrderEntity.class)
                .field("status", "orderStatus").byDefault().register();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public OrderEntity convertDtoToEntity(OrderDto orderDto) {
        return mapperFacade.map(orderDto, OrderEntity.class);

    }
}
