package net.class101.server1.service;

import net.class101.server1.model.OrderItem;
import net.class101.server1.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductState {
     void isValidateItem(Map<Long, Product> productList, List<OrderItem> orderList, OrderItem item);
}
