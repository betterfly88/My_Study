package com.betterfly.objectmapping.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Setter
@Getter
@NoArgsConstructor
public class OrderDto {
    private long serialNo;
    private long orderId;
    private String orderingUserName;
    private int status;
    private List<Product> orderProducts;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;

    public static List<OrderDto> getOrderDtoList(int size){
        List<OrderDto> orderList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
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

    private static List<Product> generateProduct(){
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
}
