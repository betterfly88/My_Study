package com.class101.homework.service;

import com.class101.homework.model.OrderItem;
import com.class101.homework.model.Product;

import java.util.Map;

public interface ProductState {
     void isValidateItem(Map<Long, Product> productList, Map<Long, OrderItem> orderList, OrderItem item);
}
