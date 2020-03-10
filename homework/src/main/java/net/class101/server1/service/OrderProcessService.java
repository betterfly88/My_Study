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
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderProcessService{
    private final FetchProductService fetchProductService;
    private Map<Long, Product> productList = new ConcurrentHashMap<Long, Product>();
    private Map<String, List<OrderItem>> userOrderList = new HashMap<>();
    private List<OrderItem> itemList = new ArrayList<>();

    @PostConstruct
    public void init() throws IOException {
        fetchProductService.read();
        productList = fetchProductService.getProductList();
    }

    public void setUserOrderList(Map<String, List<OrderItem>> userOrderList){
        this.userOrderList = userOrderList;
    }

    public Map<Long, Product> getProductList(){
        return this.productList;
    }

    @Async("orderTaskExecutor")
    public synchronized void addItem(User user){
        OrderItem item = findItemDetail(user.getProductId(), user.getOrderCounts());
        item.getProductType().isValidateItem(productList, userOrderList.get(user.getUserName()), item);

        /*
            하려는 일은, 해당 유저(key)에게 이미 그 상품이 있으면
            그 유저의 총 주문 개수를 올려줘야함.
         */
        if(userOrderList.get(user.getUserName()) != null){
            for (OrderItem i: userOrderList.get(user.getUserName())) {
                if(i.getProductId() == user.getProductId()){
                    item.setCounts(i.getCounts() + user.getOrderCounts());
                }
            }
        }

        itemList.add(item);
        userOrderList.put(user.getUserName(), itemList);
        deductProductList(item);
    }

    public void order(User user){
        TotalOrder totalOrder = TotalOrder.of(userOrderList, user);

        printResult(user, totalOrder);
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

    public void printResult(User user, TotalOrder totalOrder){
        System.out.println("주문 내역 : \n");
        System.out.println("=================================================");
        totalOrder.getOrderList().get(user.getUserName()).forEach(v ->{
            System.out.println(v.getTitle() + " - " + v.getCounts() +"개");
        });

        System.out.println("=================================================");
        System.out.println("주문금액 : "+ Utils.setComma(totalOrder.getOrderPrice())+"원");
        System.out.println("배송비 : "+ Utils.setComma(totalOrder.getShippingCost())+"원");
        System.out.println("=================================================");
        System.out.println("지불금액 : "+ Utils.setComma(totalOrder.getPayment()) +"원");
        System.out.println("=================================================");
    }

    private void deductProductList(OrderItem item){
        int left = productList.get(item.getProductId()).getStocks() - item.getCounts();
        productList.get(item.getProductId()).setStocks(left);
    }

    public void exitOrder(){
        System.out.println("고객님의 주문 감사합니다.");
        System.exit(-1);
    }
}
