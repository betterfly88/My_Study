package net.class101.server1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
@AllArgsConstructor(staticName = "of")
public class TotalOrder{
    private Map<String, OrderItem> orderList;
    private long orderPrice;
    @Builder.Default
    private long shippingCost = 0L;
    private long payment;

    private static long paymentAmount(Map<String, OrderItem> orderItemList){
        return orderItemList.values().stream().mapToLong(v -> v.getPrice() * v.getCounts()).sum();
    }

    private static boolean containsKitItem(Map<String, OrderItem> orderItemList){
        return orderItemList.values()
                .stream()
                .anyMatch(v -> v.getProductType() == ProductType.KIT);
    }

    private static long hasShippingCost(Map<String, OrderItem> orderItemList, long orderPrice){
        return orderPrice < 50000L && containsKitItem(orderItemList) ? 5000L : 0L;
    }

    public static TotalOrder of(Map<String, OrderItem> orderItemList){
        long orderPrice = paymentAmount(orderItemList);
        long shippingCost = hasShippingCost(orderItemList, orderPrice);

        return TotalOrder.builder()
                .orderList(orderItemList)
                .orderPrice(orderPrice)
                .shippingCost(shippingCost)
                .payment(orderPrice + shippingCost)
                .build();
    }
}
