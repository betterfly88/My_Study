package net.class101.server1.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class OrderItem {
    private long productId;
    private ProductType productType;
    private String title;
    private long price;
    @Setter
    private int counts;
}
