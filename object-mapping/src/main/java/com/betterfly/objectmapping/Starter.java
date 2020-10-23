package com.betterfly.objectmapping;

import com.betterfly.objectmapping.model.OrderDto;
import com.betterfly.objectmapping.service.AbstractMappingService;
import com.betterfly.objectmapping.service.MapStructServiceImpl;
import com.betterfly.objectmapping.service.ModelMapperServiceImpl;
import com.betterfly.objectmapping.service.OrikaServiceImpl;

import java.util.List;

public class Starter {

    public static void main(String[] args) {
        List<OrderDto> orderDtoList = OrderDto.getOrderDtoList(1_000_000);

        AbstractMappingService mapStructService = new MapStructServiceImpl();
        AbstractMappingService orikaService = new OrikaServiceImpl();
        AbstractMappingService mapperService = new ModelMapperServiceImpl();
        for (int i = 0; i <10 ; i++) {
            mapStructService.execute(orderDtoList);
//            orikaService.execute(orderDtoList);
//            mapperService.execute(orderDtoList);
        }
    }
}
