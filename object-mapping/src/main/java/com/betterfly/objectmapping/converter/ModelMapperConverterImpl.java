package com.betterfly.objectmapping.converter;

import com.betterfly.objectmapping.entity.OrderEntity;
import com.betterfly.objectmapping.mapper.Converter;
import com.betterfly.objectmapping.model.OrderDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ModelMapperConverterImpl implements Converter {
    private ModelMapper modelMapper;

    public ModelMapperConverterImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public OrderEntity convertDtoToEntity(OrderDto orderDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        return (OrderEntity) modelMapper.typeMap(OrderDto.class, OrderEntity.class).addMappings(mapper -> {
            mapper.map(src -> src.getStatus(),
                    OrderEntity::setOrderStatus);
        });
    }
}
