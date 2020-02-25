package net.class101.server1.service;

import net.class101.server1.exception.SoldOutException;
import net.class101.server1.model.User;
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
            for (int i = 0; i < 3; i++) {
                System.out.println("i 번째 수행합니다 == "+ i);
                orderItem("Thread 1",39712L, 2);
            }
        });

        Thread t2 =new Thread(() ->{
            orderItem("Thread 2",39712L, 5);
        });

//        Thread t3 =new Thread(() ->{
//            orderItem(39712L, 2);
//        });
//
//        Thread t4 = new Thread(() ->{
//            orderItem(39712L, 4);
//        });

        executor.execute(t1);
        executor.execute(t2);
//        executor.execute(t3);
//        executor.execute(t4);
    }


    @Test
    public void executorService_Test(){
        executor.submit(new Runnable() {
            @Override
            public void run() {
                orderItem("Thread 1",39712L, 2);
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                orderItem("Thread 2",39712L, 3);
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                orderItem("Thread 3",39712L, 7);
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                orderItem("Thread 4", 39712L, 5);
            }
        });
    }

    private void orderItem(String userName, long pid, int counts){
        User user = new User(userName);
        user.setProductId(pid);
        user.setOrderCounts(counts);
        orderService.addItem(user);
        System.out.println("[Thread Name] -> "+Thread.currentThread().getName() + " 의 남은 개수 : " + orderService.getProductList().get(pid).getStocks());
    }

    @After
    public void tearDown(){
        executor.shutdown();
    }
}
