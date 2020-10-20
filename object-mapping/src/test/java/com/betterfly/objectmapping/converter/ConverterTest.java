package com.betterfly.objectmapping.converter;

import com.betterfly.objectmapping.entity.OrderEntity;
import com.betterfly.objectmapping.mapper.MapStructConverter;
import com.betterfly.objectmapping.model.OrderDto;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.Assert.*;
public class ConverterTest {

    private OrikaConverterImpl orikaConverterImpl;
    private ModelMapperConverterImpl modelMapperConverter;
    private OrderDto orderDto;

    @Before
    public void init(){
        orikaConverterImpl = new OrikaConverterImpl();
        modelMapperConverter = new ModelMapperConverterImpl();

        orderDto = new OrderDto();
        orderDto.setSerialNo(1L);
        orderDto.setOrderId(new Random().nextLong());
        orderDto.setOrderingUserName("betterFLY");
        orderDto.setStatus(new Random().nextInt(10));
        orderDto.setOrderProducts(null);
        orderDto.setOrderDate(LocalDateTime.now());
        orderDto.setDeliveryDate(LocalDateTime.now().plusDays(4L));
    }

    @Test
    public void orika_converter(){
        // given && when
        OrderEntity entity = orikaConverterImpl.convertDtoToEntity(orderDto);

        // then
        assertTrue(entity.getOrderingUserName().equals("betterFLY"));
        assertTrue(entity.getOrderStatus() == orderDto.getStatus());
    }

    @Test
    public void mapStruct_converter(){
        // given && when
        OrderEntity entity = MapStructConverter.INSTANCE.convertDtoToEntity(orderDto);

        // then
        assertTrue(entity.getOrderingUserName().equals("betterFLY"));
        assertTrue(entity.getOrderStatus() == orderDto.getStatus());
    }

    @Test
    public void modelMapper_converter(){
        OrderEntity entity = modelMapperConverter.convertDtoToEntity(orderDto);

        // then
        assertTrue(entity.getOrderingUserName().equals("betterFLY"));
        assertTrue(entity.getOrderStatus() == orderDto.getStatus());
    }
}