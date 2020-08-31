package com.betterfly.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class RealBookService implements BookService{
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findByBooks() {
        return IntStream.range(0, 10)
                .mapToObj(idx -> new Book((long)idx, "신간_책_"+idx))
                .collect(Collectors.toList());
    }

    @Override
    public void rent(Book b) {
        System.out.println(String.format("대여한 책은 <%s> 입니다.", b.getTitle()));
    }
}
