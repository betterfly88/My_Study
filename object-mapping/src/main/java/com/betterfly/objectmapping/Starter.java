package com.betterfly.objectmapping;

import com.betterfly.objectmapping.converter.ModelMapperConverterImpl;
import com.betterfly.objectmapping.converter.OrikaConverterImpl;
import com.betterfly.objectmapping.entity.OrderEntity;
import com.betterfly.objectmapping.mapper.MapStructConverter;
import com.betterfly.objectmapping.model.OrderDto;
import com.betterfly.objectmapping.model.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Starter {
    public static void main(String[] args) {
        Starter s = new Starter();
        s.init();
        s.timeCheck();
    }


    private OrikaConverterImpl orikaConverterImpl;
    private ModelMapperConverterImpl modelMapperConverter;


    public List<OrderDto> init(){
        List<OrderDto> orderList = new ArrayList<>();

//        orikaConverterImpl = new OrikaConverterImpl();
        modelMapperConverter = new ModelMapperConverterImpl();

        for (int i = 0; i < 500_000; i++) {
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

    public void mapStruct_converter(){
        // given && when
        long start =  System.currentTimeMillis();
        // given && when
        List<OrderEntity> entity =
                init().stream()
                        .map(MapStructConverter.INSTANCE::convertDtoToEntity)
                        .collect(Collectors.toList());


        // then
        long end = System.currentTimeMillis();
        double secDiffTime = (end - start)/1000.0;
        System.out.println("실행시간(s) : "+secDiffTime);
    }

    public void modelMapper_converter(){
        long start =  System.currentTimeMillis();
        // given && when
        List<OrderEntity> entity =
                init().stream()
                        .map(modelMapperConverter::convertDtoToEntity)
                        .collect(Collectors.toList());


        // then
        long end = System.currentTimeMillis();
        double secDiffTime = (end - start)/1000.0;
        System.out.println("실행시간(s) : "+secDiffTime);
    }

    public void orika_converter(){
        long start =  System.currentTimeMillis();
        // given && when
        List<OrderEntity> entity =
                init().stream()
                        .map(orikaConverterImpl::convertDtoToEntity)
                        .collect(Collectors.toList());


        // then
        long end = System.currentTimeMillis();
        double secDiffTime = (end - start)/1000.0;
        System.out.println("실행시간(s) : "+secDiffTime);
    }

    public void timeCheck(){
        for (int i = 0; i < 10; i++) {
            mapStruct_converter();
//            orika_converter();
//            modelMapper_converter();
        }
    }
}
