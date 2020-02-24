package net.class101.server1.service;

import net.class101.server1.exception.OrderException;
import net.class101.server1.exception.SoldOutException;
import net.class101.server1.model.OrderItem;
import net.class101.server1.model.ProductType;
import net.class101.server1.model.TotalOrder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderProcessServiceTest {
    private OrderProcessService orderService;
    private FetchProductService fetchProductService;

    private Map<Long, OrderItem> orderItemList = new HashMap<>();

    @Before
    public void init() throws IOException {
        fetchProductService = new FetchProductService();
        fetchProductService.setFileName("product_list.csv");
        orderService = new OrderProcessService(fetchProductService);
        orderService.init();
    }

    @Test(expected = OrderException.class)
    public void 아이템_추가(){
        orderService.addItem(45947, 1);
        orderService.addItem(45947, 1);
    }

    @Test
    public void 결과_출력(){
        //given
        OrderItem o1 = OrderItem.builder().productId(10L).price(5000L).title("샘플1").counts(1).productType(ProductType.KIT).build();
        OrderItem o2 = OrderItem.builder().productId(15L).price(10000L).title("샘플2").counts(1).productType(ProductType.CLASS).build();
        OrderItem o3 = OrderItem.builder().productId(30L).price(2000L).title("샘플3").counts(5).productType(ProductType.KIT).build();

        orderItemList.put(10L, o1);
        orderItemList.put(15L, o2);
        orderItemList.put(30L, o3);

        orderService.setOrderItemList(orderItemList);

        // when
        TotalOrder order = TotalOrder.of(orderItemList);

        // then
        orderService.printResult(order);
    }

    @Test
    public void 남은재고_확인(){
        //given
        orderService.addItem(39712, 7);
        orderService.order();

        //when
        int stock = orderService.getProductList().get(39712L).getStocks();

        //then
        assertTrue(stock == 1);
    }

    @Test(expected = SoldOutException.class)
    public void SoldOutException(){
        //given
        orderService.addItem(39712, 7);
        orderService.order();

        //when
        orderService.getProductList().get(39712L).getStocks();

        //then
        orderService.addItem(39712, 2);
    }
}