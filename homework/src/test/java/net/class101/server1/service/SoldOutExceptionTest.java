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

        executor = Executors.newScheduledThreadPool(10);
    }

    @Test
    public void multiThreadTest(){


        Thread t2 =new Thread(() ->{
            orderItem("Thread 2",39712L, 5);
        });

        Thread t3 =new Thread(() ->{
            orderItem("Thread 3",39712L, 3);
        });

        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 3; i++) {
                System.out.println("i 번째 수행합니다 == "+ i);
                orderItem("Thread 1",39712L, 2);
            }
        });

        Thread t4 = new Thread(() ->{
            orderItem("Thread 4",39712L, 4);
        });

        Thread t5 = new Thread(() ->{
            orderItem("Thread 5",39712L, 2);
        });

        // 같은 call stack 에서 사용됨
        t3.start(); // 3
        t4.start(); // 4
        t2.start(); // 5
        t1.start();
        t5.start();

        // 각 thread call-stack에서 수행되기 때문에 디버깅 & 정확한 추적이 어려움
//        executor.execute(t2);
//        executor.execute(t5);
//        executor.execute(t1);
//        executor.execute(t3);
//        executor.execute(t4);
    }


    @Test
    public void executorService_Test(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                orderItem("Thread 1",39712L, 2);
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                orderItem("Thread 2",39712L, 3);
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                orderItem("Thread 3",39712L, 7);
            }
        });

        executor.execute(new Runnable() {
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
        System.out.println("[Thread Name] -> "+userName + " 의 남은 개수 : " + orderService.getProductList().get(pid).getStocks());
    }

    @After
    public void tearDown(){
        executor.shutdown();
    }
}
