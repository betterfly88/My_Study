package com.class101.homework.service;

import com.class101.homework.exception.SoldOutException;
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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

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
    public void multiThreadTest(){
        Thread t1 = new Thread(() ->{
            orderItem(39712L, 2);
        });

        Thread t2 =new Thread(() ->{
            orderItem(39712L, 3);
        });
        Thread t3 =new Thread(() ->{
            orderItem(39712L, 2);
        });
        Thread t4 = new Thread(() ->{
            orderItem(39712L, 4);
        });

        Thread t5 =new Thread(() ->{
            orderItem(39712L, 5);
        });

        t1.run();
        t2.run();
        t3.run();
        t4.run();
        t5.run();
    }

    private void orderItem(long pid, int counts){
        orderService.addItem(pid, counts);

        System.out.println("[This Thread]"+Thread.currentThread().getName() + " 의 남은 개수 : " + orderService.getProductList().get(pid).getStocks());
        orderService.order();
    }

    @Test(expected = SoldOutException.class)
    public void createThread() throws InterruptedException, ExecutionException {
        executor1.submit(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<7; i++){
                    orderService.addItem(39712L, 1);

                    System.out.println(Thread.currentThread().getName() + " 의 남은 개수 : " + orderService.getProductList().get(39712L).getStocks());
                    orderService.order();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }).get();

        executor1.submit(new Runnable() {
            @Override
            public void run() {
                orderService.addItem(39712L, 3);
                orderService.order();

                System.out.println(Thread.currentThread().getName() + " 의 남은 개수 : " + orderService.getProductList().get(39712L).getStocks());
            }
        }).get();
    }

    @After
    public void close(){
        executor1.shutdown();
    }
}
