package com.betterfly.objectmapping.converter;

import com.betterfly.objectmapping.entity.OrderEntity;
import com.betterfly.objectmapping.model.OrderDto;
import com.betterfly.objectmapping.model.Product;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class MappingPerformanceTest {
    private OrikaConverterImpl orikaConverterImpl;
    private ModelMapperConverterImpl modelMapperConverter;


    @Before
    public void init(){
        orikaConverterImpl = new OrikaConverterImpl();
        modelMapperConverter = new ModelMapperConverterImpl();

        getOrderList();
    }

    private List<OrderDto> getOrderList() {
        List<OrderDto> orderList = new ArrayList<>();

        for (int i = 0; i < 200_000; i++) {
            OrderDto orderDto = new OrderDto();
            orderDto.setSerialNo(new Random().nextLong());
            orderDto.setOrderId(new Random().nextLong());
            orderDto.setOrderingUserName("betterFLY_Test");
            orderDto.setStatus(new Random().nextInt(5));
            orderDto.setOrderDate(LocalDateTime.now());
            orderDto.setOrderDate(LocalDateTime.now().plusDays(new Random().nextInt(10)));


            orderDto.setOrderProducts(generateProduct());
            orderList.add(orderDto);
        }

        return orderList;
    }


    private List<Product> generateProduct(){
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product p = new Product();
            p.setName("p_"+i);
            p.setPrice((38890L * new Random().nextInt(5)));
            p.setProductDate(LocalDateTime.now().minusDays(new Random().nextInt(20)));

            list.add(p);
        }

        return list;
    }

    public void orika_converter(){
        long start =  System.currentTimeMillis();
        // given && when
        List<OrderEntity> entity =
                getOrderList().stream()
                        .map(orikaConverterImpl::convertDtoToEntity)
                        .collect(Collectors.toList());


        // then
        System.out.println(entity.size());

        long end = System.currentTimeMillis();
        double secDiffTime = (end - start)/1000.0;
        System.out.println("실행시간(s) : "+secDiffTime);
    }

    @Test
    public void timeCheck(){
        for (int i = 0; i < 10; i++) {
            orika_converter();
        }
    }
}
