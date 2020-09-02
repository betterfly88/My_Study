package com.betterfly.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Test
    public void mockito(){
        BookRepository bookRepositoryMock = mock(BookRepository.class);

        Book hibernateBook = new Book();
        hibernateBook.setTitle("hibernate");
        when(bookRepositoryMock.save(any())).thenReturn(bookRepositoryMock);
        BookService bookService = new RealBookService();

    }
}