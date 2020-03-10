package net.class101.server1.service;

import net.class101.server1.exception.OrderException;
import net.class101.server1.exception.SoldOutException;
import net.class101.server1.model.OrderItem;
import net.class101.server1.model.ProductType;
import net.class101.server1.model.TotalOrder;
import net.class101.server1.model.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderProcessServiceTest {
    private OrderProcessService orderService;
    private FetchProductService fetchProductService;

    private Map<String, List<OrderItem>> orderItemList = new HashMap<>();

    @Before
    public void init() throws IOException {
        fetchProductService = new FetchProductService();
        fetchProductService.setFileName("product_list.csv");
        orderService = new OrderProcessService(fetchProductService);
        orderService.init();
    }

    @Test(expected = OrderException.class)
    public void 아이템_추가(){
        // given
        User user = new User("User 1");
        user.setProductId(45947L);
        user.setOrderCounts(1);
        // when & then
        orderService.addItem(user);
        orderService.addItem(user);
    }

    @Test
    public void 결과_출력(){
        //given
        OrderItem o1 = OrderItem.builder().productId(10L).price(5000L).title("샘플1").counts(1).productType(ProductType.KIT).build();
        OrderItem o2 = OrderItem.builder().productId(15L).price(10000L).title("샘플2").counts(1).productType(ProductType.CLASS).build();
        OrderItem o3 = OrderItem.builder().productId(30L).price(2000L).title("샘플3").counts(5).productType(ProductType.KIT).build();

        User user = new User("A User");
        List<OrderItem> orderList = new ArrayList<>();
        orderList.add(o1);
        orderList.add(o2);
        orderList.add(o3);

        orderItemList.put(user.getUserName(), orderList);
        orderService.setUserOrderList(orderItemList);


        // when
        TotalOrder order = TotalOrder.of(orderItemList, user);

        // then
        orderService.printResult(user, order);
    }

    @Test
    public void 남은재고_확인(){
        //given
        User user = new User("User 1");
        user.setProductId(39712L);
        user.setOrderCounts(7);
        orderService.addItem(user);
        orderService.order(user);

        //when
        int stock = orderService.getProductList().get(39712L).getStocks();

        //then
        assertTrue(stock == 1);
    }

    @Test(expected = SoldOutException.class)
    public void SoldOutException(){
        //given
        User user = new User("User 1");
        user.setProductId(39712L);
        user.setOrderCounts(7);
        orderService.addItem(user);
        orderService.order(user);

        //when
        orderService.getProductList().get(39712L).getStocks();

        //then
        user.setOrderCounts(3);
        orderService.addItem(user);
    }
}