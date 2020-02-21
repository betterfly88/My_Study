package com.class101.homework.service;

import com.class101.homework.common.Utils;
import com.class101.homework.model.OrderItem;
import com.class101.homework.model.Product;
import com.class101.homework.model.TotalOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderProcessService{
    private final FetchProductService fetchProductService;
    private Map<Long, Product> productList = new ConcurrentHashMap<Long, Product>();
    private Map<Long, OrderItem> orderItemList = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() throws IOException {
        fetchProductService.read();
        productList = fetchProductService.getProductList();
    }

    public void setOrderItemList(Map<Long, OrderItem> orderItemList){
        this.orderItemList = orderItemList;
    }

    public Map<Long, Product> getProductList(){
        return this.productList;
    }

    @Async("orderTaskExecutor")
    public void addItem(long pId, int pCount){
        log.info(Thread.currentThread().getName());

        OrderItem item = findItemDetail(pId, pCount);
        item.getProductType().isValidateItem(productList, orderItemList, item);

        if(orderItemList.containsKey(pId)){
            item.setCounts(orderItemList.get(pId).getCounts() + pCount);
        }

        orderItemList.put(pId, item);
    }

    public void order(){
        TotalOrder totalOrder = TotalOrder.of(orderItemList);

        printResult(totalOrder);
        deductProductList();
    }

    private OrderItem findItemDetail(long pId, int pCount){
        Product productDetail = Optional.ofNullable(productList.get(pId)).orElseThrow(IllegalArgumentException::new);

        return OrderItem.builder()
                    .productId(pId)
                    .title(productDetail.getTitle())
                    .price(productDetail.getPrice())
                    .productType(productDetail.getProductType())
                    .counts(pCount)
                .build();
    }

    public void printResult(TotalOrder totalOrder){
        System.out.println("주문 내역 : \n");
        System.out.println("=================================================");
        totalOrder.getOrderList().values().forEach(v ->{
            System.out.println(v.getTitle() + " - " + v.getCounts() +"개");
        });

        System.out.println("=================================================");
        System.out.println("주문금액 : "+ Utils.setComma(totalOrder.getOrderPrice())+"원");
        System.out.println("배송비 : "+ Utils.setComma(totalOrder.getShippingCost())+"원");
        System.out.println("=================================================");
        System.out.println("지불금액 : "+ Utils.setComma(totalOrder.getPayment()) +"원");
        System.out.println("=================================================");
    }

    public void deductProductList(){
        orderItemList.entrySet().forEach(e ->{
            int leftStocks = productList.get(e.getKey()).getStocks() - e.getValue().getCounts();
            productList.get(e.getKey()).setStocks(leftStocks);
        });
    }

    public void exitOrder(){
        System.out.println("고객님의 주문 감사합니다.");
        System.exit(-1);
    }
}
