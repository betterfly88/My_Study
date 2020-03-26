package com.theJava.reflection.store;

public class NewBook {

    public static String bookName = "theJava";
    private String author = "betterFLY";
    private int stock = 10;

    public NewBook(){

    }

    public NewBook(String bookName){
        this.bookName = bookName;
    }

    public void printBookName(){
        System.out.println(bookName);
    }

    public int leftStock(int oStock, int orderCount){
        return oStock - orderCount;
    }
}
