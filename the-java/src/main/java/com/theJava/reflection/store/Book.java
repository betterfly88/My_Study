package com.theJava.reflection.store;

public class Book {
    private static final int serialNum = 99999;
    private String bookName = "Java - Reflection story";
    private static String publisher = "Java Factory";
    public String author = "betterFLY";



    public Book(){

    }

    public Book(String bookName, String publisher, String author){
        this.bookName = bookName;
        this.author = author;
        this.type = author;
    }

    @MyBookAnnotation("aaaa")
    protected String type = "Hardcover";

    @MyBookAnnotation(value = "bookStory", name = "aa", age=220)
    private void privatePrint(){
        System.out.println("private print method");
    }

    public void publicPrint(){
        System.out.println("public print method");
    }

    public int boxedInt(){
        return 9999;
    }
}
