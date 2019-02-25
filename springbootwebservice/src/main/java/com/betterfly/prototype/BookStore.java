package com.betterfly.prototype;

import com.betterfly.prototype.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.02.25
 */
public class BookStore extends BookPrototype {
    private String name;
//    int / long : primitive >> immutable --> 불변객체

    private List<Book> list = new ArrayList<>();
//    VO, Map , List >> mutable --> 가변객체

    @Override
    public void makeBookList() {
        for (int i=0; i<10 ;i++){
            Book b = new Book();
            b.setTitle("책_"+i);
            b.setSerial(i);
            this.getList().add(b);
        }
    }

    public BookStore clone(){
        BookStore store = new BookStore();
        for(Book b : this.getList()){
            store.getList().add(b);
        }

        return store;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}
