package com.betterfly.objectmapping.mapper;

import com.betterfly.objectmapping.entity.OrderEntity;
import com.betterfly.objectmapping.model.OrderDto;

public interface Converter {
    OrderEntity convert(OrderDto orderDto);
}
