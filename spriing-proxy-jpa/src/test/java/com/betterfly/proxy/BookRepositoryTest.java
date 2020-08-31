package com.betterfly.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

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
}