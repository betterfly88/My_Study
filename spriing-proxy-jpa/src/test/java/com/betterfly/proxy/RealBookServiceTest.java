package com.betterfly.proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RealBookServiceTest {
    @Autowired
    BookService realBookService;

    @Autowired
    BookService bookServiceProxy;

    BookService dynamicBookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class}, new InvocationHandler() {
        BookService bookService = new RealBookService();

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("rent")){
                System.out.println("before dynamicProxy");
                Object invoke = method.invoke(bookService, args);

                System.out.println("after dynamicProxy");
                return invoke;
            }

            return  method.invoke(bookService, args);
        }
    });

    @Test
    public void 책을_렌트한다(){
        //given
        MethodInterceptor handler = new MethodInterceptor() {
            BookService bookService = new RealBookService();

            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before dynamicProxy");
                Object invoke = method.invoke(bookService, objects);

                System.out.println("after dynamicProxy");
                return invoke;
            }
        };

        //when
        RealBookService cglibProxyService = (RealBookService) Enhancer.create(RealBookService.class, handler);
        Book b = new Book();
        b.setTitle("Proxy in Spring");

        //then
        cglibProxyService.rent(b);
    }

    @Test
    public void 저장된_책의_사이즈를_확인(){
        // when
        List<Book> books = bookServiceProxy.findByBooks();

        // then
        assertTrue(books.size() == 10);
    }

    @Test
    public void 다이나믹_프록시(){
        Book b = new Book();
        b.setTitle("다이나믹 프록시 교재");

        dynamicBookService.rent(b);
        dynamicBookService.findByBooks();
    }
}