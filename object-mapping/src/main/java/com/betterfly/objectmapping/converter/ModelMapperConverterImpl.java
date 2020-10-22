package com.betterfly.objectmapping.converter;

import com.betterfly.objectmapping.entity.OrderEntity;
import com.betterfly.objectmapping.mapper.Converter;
import com.betterfly.objectmapping.model.OrderDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class ModelMapperConverterImpl implements Converter {
    private ModelMapper modelMapper;

    public ModelMapperConverterImpl() {
        modelMapper = new ModelMapper();
        PropertyMap<OrderDto, OrderEntity> entityMap = new PropertyMap<OrderDto, OrderEntity>() {
            protected void configure() {
                map().setOrderStatus(source.getStatus());
            }
        };
        modelMapper.addMappings(entityMap);
    }

    @Override
    public OrderEntity convertDtoToEntity(OrderDto orderDto) {

        return modelMapper.map(orderDto, OrderEntity.class);
    }
}
