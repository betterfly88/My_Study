package net.class101.server1.service;

import net.class101.server1.exception.SoldOutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OrderProcessService.class, FetchProductService.class})
public class SoldOutExceptionTest {

    private OrderProcessService orderService;
    private FetchProductService fetchProductService;

    ExecutorService executor;

    @Before
    public void init() throws IOException {
        fetchProductService = new FetchProductService();
        fetchProductService.setFileName("product_list.csv");
        orderService = new OrderProcessService(fetchProductService);
        orderService.init();

        executor = Executors.newFixedThreadPool(10);
    }

    @Test(expected = SoldOutException.class)
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

        t1.run();
        t2.run();
        t3.run();
        t4.run();
    }


    @Test
    public void executorService_Test(){
        executor.submit(new Runnable() {
            @Override
            public void run() {
                orderItem(39712L, 2);
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                orderItem(39712L, 3);
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                orderItem(39712L, 7);
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                orderItem(39712L, 5);
            }
        });
    }

    private void orderItem(long pid, int counts){
        orderService.addItem(pid, counts);
        System.out.println("[Thread Name] -> "+Thread.currentThread().getName() + " 의 남은 개수 : " + orderService.getProductList().get(pid).getStocks());
    }

    @After
    public void tearDown(){
        executor.shutdown();
    }
}
