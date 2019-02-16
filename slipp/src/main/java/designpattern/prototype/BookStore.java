package designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.02.14
 */
public abstract class BookStore implements Cloneable{
    private String area;
    private List<Book> bookList = new ArrayList<Book>();
    protected abstract void makeBookList();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "area='" + area + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}