package com.class101.homework.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class Product {
    private long productId;
    private ProductType productType;
    private String title;
    private long price;
    @Setter
    private int stocks;


    public static Product bindToProduct(String [] rows){
        return Product.builder()
                    .productId(Long.parseLong(rows[0]))
                    .productType(ProductType.setProductType(rows[1]))
                    .title(rows[2])
                    .price(Long.parseLong(rows[3]))
                    .stocks(Integer.parseInt(rows[4]))
                .build();
    }

    @Override
    public String toString(){
        return String.join("\t", String.valueOf(this.getProductId()), this.getTitle(), String.valueOf(this.getPrice()), String.valueOf(this.getStocks()));
    }
}