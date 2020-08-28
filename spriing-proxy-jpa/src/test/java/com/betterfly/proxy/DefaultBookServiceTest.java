package com.betterfly.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultBookServiceTest {

    @Autowired
    DefaultBookService defaultBookService;

    @Autowired
    BookRepository bookRepository;


    @Test
    public void BookRepository_인스턴스가_생성된다(){
        assertNotNull(bookRepository);
    }

    @Test
    public void BookRepository_저장_후_조회(){
        // given
        Book book = new Book();
        book.setTitle("Spring Data JPA");
        bookRepository.save(book);

        // when
        Optional<Book> b = bookRepository.findById(1L);

        // then
        assertTrue(b.get().getTitle().equals("Spring Data JPA"));
    }

    @Test
    public void 책을_렌트한다(){
        //when
        Book b = new Book();
        b.setTitle("Hibernate");

        //then
        defaultBookService.rent(b);
    }
}