package com.betterfly.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface BookService {
    void rent(Book book);
}
