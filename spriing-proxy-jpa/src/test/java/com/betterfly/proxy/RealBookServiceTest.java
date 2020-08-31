package com.betterfly.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RealBookServiceTest {
    @Autowired
    BookService realBookService;

    @Autowired
    BookService bookServiceProxy;

    @Test
    public void 책을_렌트한다(){
        //when
        Book b = new Book();
        b.setTitle("Proxy in Spring");

        //then
        realBookService.rent(b);
    }

    @Test
    public void 저장된_책의_사이즈를_확인(){
        // when
        List<Book> books = bookServiceProxy.findByBooks();

        // then
        assertTrue(books.size() == 10);
    }
}