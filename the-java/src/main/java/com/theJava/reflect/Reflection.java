package com.theJava.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // FQCN(Fully Qualified Class Name) 접근
        Class<?> bookClass = Class.forName("com.theJava.reflect.NewBook");
        Constructor<?> constructor = bookClass.getConstructor(String.class);
        NewBook book = (NewBook)constructor.newInstance("New Book");

        System.out.println(book);
        System.out.println(book.bookName);

        Field bookName = bookClass.getDeclaredField("bookName");
        System.out.println(bookName.get(null));
        bookName.set(null, "The Java #2");
        System.out.println(bookName.get(null));
    }
}
