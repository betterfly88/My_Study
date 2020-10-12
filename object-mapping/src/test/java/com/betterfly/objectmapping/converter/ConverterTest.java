package com.betterfly.objectmapping.converter;

import com.betterfly.objectmapping.entity.OrderEntity;
import com.betterfly.objectmapping.mapper.MapStructConverter;
import com.betterfly.objectmapping.model.OrderDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConverterTest {

    private OrikaConverterImpl orikaConverterImpl;

    private OrderDto orderDto;

    @Before
    public void init(){
        orikaConverterImpl = new OrikaConverterImpl();
        orderDto = OrderDto.builder()
                .serialNo(1L)
                .orderId(new Random().nextLong())
                .orderingUserName("betterFLY")
                .status(new Random().nextInt(10))
                .orderProducts(null)
                .orderDate(LocalDateTime.now())
                .deliveryDate(LocalDateTime.now().plusDays(3L))
                .build();
    }

    @Test
    public void orika_converter(){
        // given && when
        OrderEntity entity = orikaConverterImpl.convert(orderDto);

        // then
        assertTrue(entity.getOrderingUserName().equals("betterFLY"));
        assertTrue(entity.getOrderStatus() == orderDto.getStatus());
    }

    @Test
    public void mapStruct_converter(){
        // given && when
        OrderEntity entity = MapStructConverter.INSTANCE.convert(orderDto);

        // then
        assertTrue(entity.getOrderingUserName().equals("betterFLY"));
        assertTrue(entity.getOrderStatus() == orderDto.getStatus());
    }
}