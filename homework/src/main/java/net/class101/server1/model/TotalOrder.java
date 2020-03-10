package net.class101.server1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Builder
@Getter
@AllArgsConstructor(staticName = "of")
public class TotalOrder{
    private Map<String, List<OrderItem>> orderList;
    private long orderPrice;
    @Builder.Default
    private long shippingCost = 0L;
    private long payment;

    private static long paymentAmount(Map<String, List<OrderItem>> orderItemList, User user){
        return orderItemList.get(user.getUserName()).stream().mapToLong(v -> v.getPrice() * v.getCounts()).sum();
    }

    private static boolean containsKitItem(Map<String, List<OrderItem>> orderItemList, User user){
        return orderItemList.get(user.getUserName())
                .stream()
                .anyMatch(v -> v.getProductType() == ProductType.KIT);
    }

    private static long hasShippingCost(Map<String, List<OrderItem>> orderItemList, long orderPrice, User user){
        return orderPrice < 50000L && containsKitItem(orderItemList, user) ? 5000L : 0L;
    }

    public static TotalOrder of(Map<String, List<OrderItem>> orderItemList, User user){
        long orderPrice = paymentAmount(orderItemList, user);
        long shippingCost = hasShippingCost(orderItemList, orderPrice, user);

        return TotalOrder.builder()
                .orderList(orderItemList)
                .orderPrice(orderPrice)
                .shippingCost(shippingCost)
                .payment(orderPrice + shippingCost)
                .build();
    }
}
