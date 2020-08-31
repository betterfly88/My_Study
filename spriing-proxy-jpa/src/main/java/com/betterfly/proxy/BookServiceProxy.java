package com.betterfly.proxy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceProxy implements BookService {

    @Autowired
    @Qualifier("realBookService")
    BookService bookService;

    @Override
    public List<Book> findByBooks() {
        List<Book> books = bookService.findByBooks();
        System.out.println(String.format("대여한 책은 %s권 입니다.", books.size()));
        return books;
    }

    @Override
    public void rent(Book b) {

    }
}
