package com.betterfly.book;

import com.betterfly.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by betterfly
 * Date : 2019.02.24
 */

@Configuration
public class BookService implements ApplicationRunner {
    @Autowired
    Book book;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(book);
    }
}
