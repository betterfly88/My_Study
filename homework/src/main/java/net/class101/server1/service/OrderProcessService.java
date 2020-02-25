package net.class101.server1.service;

import net.class101.server1.common.Utils;
import net.class101.server1.model.OrderItem;
import net.class101.server1.model.Product;
import net.class101.server1.model.TotalOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.class101.server1.model.User;
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
    private Map<String, OrderItem> orderItemList = new HashMap<>();

    @PostConstruct
    public void init() throws IOException {
        fetchProductService.read();
        productList = fetchProductService.getProductList();
    }

    public void setOrderItemList(Map<String, OrderItem> orderItemList){
        this.orderItemList = orderItemList;
    }

    public Map<Long, Product> getProductList(){
        return this.productList;
    }

    @Async("orderTaskExecutor")
    public synchronized void addItem(User user){
        OrderItem item = findItemDetail(user.getProductId(), user.getOrderCounts());
        item.getProductType().isValidateItem(productList, orderItemList, item);

        if(orderItemList.containsKey(user.getProductId())){
            item.setCounts(orderItemList.get(user.getProductId()).getCounts() + user.getOrderCounts());
        }

        orderItemList.put(user.getUserName(), item);
        deductProductList();
    }

    public void order(){
        TotalOrder totalOrder = TotalOrder.of(orderItemList);

        printResult(totalOrder);
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

    private void deductProductList(){
        orderItemList.values().forEach(values ->{
            int leftStocks = productList.get(values.getProductId()).getStocks() - values.getCounts();
            productList.get(values.getProductId()).setStocks(leftStocks);
        });
    }

    public void exitOrder(){
        System.out.println("고객님의 주문 감사합니다.");
        System.exit(-1);
    }
}
