package com.theJava.reflection.store;

public class SubBook {
    private static final int serialNum = 99999;
    private String bookName = "Java - Reflection story";
    private static String publisher = "Java Factory";
    public String author = "betterFLY";
    protected String type = "Hardcover";

    public SubBook(){

    }

    public SubBook(String bookName, String publisher, String author){
        this.bookName = bookName;
        this.author = author;
        this.type = author;
    }

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
