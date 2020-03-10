package net.class101.server1.model;

import net.class101.server1.common.ErrorStatus;
import net.class101.server1.exception.OrderException;
import net.class101.server1.exception.SoldOutException;
import net.class101.server1.service.ProductState;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Getter
public enum ProductType implements ProductState {
    CLASS(0, "클래스"){
        @Override
        public void isValidateItem(Map<Long, Product> productList, List<OrderItem> orderList, OrderItem item) {
            if (productList.get(item.getProductId()).getStocks() < item.getCounts()){

                throw new SoldOutException("["+productList.get(item.getProductId()).getTitle() + "] 해당 상품의 재고가 부족합니다.\n " +
                        "남은 재고 : "+ productList.get(item.getProductId()).getStocks()+"개");
            }

            if(item.getCounts() > 1) {
                throw new OrderException(ErrorStatus.EXCEED_ORDER_CLASS);
            }

            if (orderList != null && orderList.stream().anyMatch(v -> v.getProductId() == item.getProductId())){
                throw new OrderException(ErrorStatus.ALREADY_EXISTS_CLASS);
            }
        }
    },

    KIT(1, "키트"){
        @Override
        public void isValidateItem(Map<Long, Product> productList, List<OrderItem> orderList, OrderItem item) {
            if (productList.get(item.getProductId()).getStocks() < item.getCounts()){

                throw new SoldOutException("["+productList.get(item.getProductId()).getTitle() + "] 해당 상품의 재고가 부족합니다.\n " +
                        "남은 재고 : "+ productList.get(item.getProductId()).getStocks()+"개" + ", [주문 수량 :"+item.getCounts()+ "]");
            }

            if(orderList != null &&
                    orderList.stream().filter(v -> item.getProductType() == ProductType.KIT && v.getProductId() == item.getProductId())
                    .anyMatch(v->{
                        return item.getCounts() > productList.get(item.getProductId()).getStocks();
                    })){

                throw new SoldOutException("["+productList.get(item.getProductId()).getTitle() + "] 해당 상품의 재고가 부족합니다.\n " +
                        "남은 재고 : "+ productList.get(item.getProductId()).getStocks()+"개" + ", [주문 수량 :"+item.getCounts()+ "]");
            }
        }
    }
    ;

    private int typeCode;
    private String typeName;

    ProductType(int typeCode, String typeName){
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public static ProductType setProductType(String typeName){
        return Stream.of(ProductType.values())
                .filter(type -> type.getTypeName().equals(typeName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}