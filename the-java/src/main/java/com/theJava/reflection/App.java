package com.theJava.reflection;

import com.theJava.reflection.store.Book;
import com.theJava.reflection.store.MyBook;
import com.theJava.reflection.store.NewBook;

import java.lang.reflect.*;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // QN
        Class<?> bookClass = Class.forName("com.theJava.reflection.store.NewBook");
        Constructor<?> constructor = bookClass.getConstructor(String.class);
        NewBook book = (NewBook)constructor.newInstance("new Book");

        System.out.println(book);

        Field bookName = bookClass.getDeclaredField("bookName");
        System.out.println(bookName.get(null));
        bookName.set(null, "The Java #2");
        System.out.println(bookName.get(null));

        Field author = bookClass.getDeclaredField("author");
        author.setAccessible(true);
        author.set(book, "betterFLY #2");
        System.out.println(author.get(book));

        Method print = bookClass.getDeclaredMethod("printBookName");
        print.invoke(book);

        Method leftStock = bookClass.getDeclaredMethod("leftStock", int.class, int.class);
        Object o = leftStock.invoke(book, 10, 9);
        System.out.println(o);
    }



    private void getAnnotation(){
        // (부모 클래스 포함)애노테이션
        MyBook.class.getAnnotations();

        // 자신의 애노테이션
        MyBook.class.getDeclaredAnnotations();

        Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);
    }

    private void refWithReflection() throws ClassNotFoundException {
        Class<?> bClass = Class.forName("com.theJava.reflection.store.Book");
        Book b = new Book();

        System.out.println("====필드====");
        Arrays.stream(bClass.getDeclaredFields()).forEach(f ->{
            // 접근제어자 무시
            f.setAccessible(true);

            try {
                System.out.printf("%s, : %s , public : %s, static : %s\n", f, f.get(b), Modifier.isPublic(f.getModifiers()), Modifier.isStatic(f.getModifiers()));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        System.out.println("====메서드====");
        Arrays.stream(bClass.getMethods()).forEach(f ->{
            System.out.println(f.getName());
        });

        System.out.println("====생성자====");
        Arrays.stream(bClass.getDeclaredConstructors()).forEach(f ->{
            System.out.println(f.getName());
        });

        System.out.println("====상속====");
        System.out.println(MyBook.class.getSuperclass());

        System.out.println("====인터페이====");
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);
    }
}
