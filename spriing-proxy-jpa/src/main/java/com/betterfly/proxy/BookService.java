package com.betterfly.proxy;

import java.util.List;

public interface BookService {
    List<Book> findByBooks();
    void rent(Book b);
}
