package com.betterfly.prototype;

/**
 * Created by betterfly
 * Date : 2019.02.25
 */
public class BookDemo {
    public static void main(String[] args) throws Exception{
        BookStore s = new BookStore();
        s.setName("강남1호점");
        s.makeBookList();

        BookStore s2 = s.clone();
        s2.setName("강남2호점");
        s.getList().remove(0);

        System.out.println(s);
        System.out.println(s2);
    }
}
