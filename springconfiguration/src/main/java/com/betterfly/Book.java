package com.betterfly;

/**
 * Created by betterfly
 * Date : 2019.02.24
 */
public class Book {
    String title;
    int serial;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", serial=" + serial +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }
}
