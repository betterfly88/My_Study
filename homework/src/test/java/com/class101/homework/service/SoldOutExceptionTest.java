package com.class101.homework.service;

import com.class101.homework.model.OrderItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OrderProcessService.class, FetchProductService.class})
public class SoldOutExceptionTest {

    private OrderProcessService orderService;
    private FetchProductService fetchProductService;

    private Map<Long, OrderItem> orderItemList = new HashMap<>();
    ExecutorService executor1;

    @Before
    public void init() throws IOException {
        fetchProductService = new FetchProductService();
        fetchProductService.setFileName("product_list.csv");
        orderService = new OrderProcessService(fetchProductService);
        orderService.init();

        executor1 = Executors.newFixedThreadPool(10);
    }


    @Test
    public void createThread() throws InterruptedException {
        executor1.submit(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    orderService.addItem(39712L, 3);

                    System.out.println(Thread.currentThread().getName() + " 의 남은 개수 : " + orderService.getProductList().get(39712L).getStocks());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                orderService.order();
            }
        });

        executor1.submit(new Runnable() {
            @Override
            public void run() {
                orderService.addItem(39712L, 3);
                orderService.order();

                System.out.println(Thread.currentThread().getName() + " 의 남은 개수 : " + orderService.getProductList().get(39712L).getStocks());
            }
        });

        Thread.sleep(10000);
    }

    @Test
    public void asdfasfas(){
        int threads = 10;
        ExecutorService service =
                Executors.newFixedThreadPool(threads);

        for (int t = 0; t < threads; t++) {
            service.submit(() -> orderService.addItem(39712L, 3));
        }
    }

    @Test
    public void 람다() throws InterruptedException {
        Thread thread = new Thread(() -> {
            for(int i=0; i<10; i++){
                orderService.addItem(39712L, 3);

                System.out.println(Thread.currentThread().getName() + " 의 남은 개수 : " + orderService.getProductList().get(39712L).getStocks());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            orderService.order();
        });

        Thread thread2 = new Thread(() -> {
            orderService.addItem(39712L, 3);
            orderService.order();

            System.out.println(Thread.currentThread().getName() + " 의 남은 개수 : " + orderService.getProductList().get(39712L).getStocks());
        });




        thread.setName("Thread #1");
        thread2.setName("Thread #2");
        thread.start();
        thread2.start();

        Thread.sleep(10000);
    }

    @After
    public void close(){
        executor1.shutdown();
    }
}
