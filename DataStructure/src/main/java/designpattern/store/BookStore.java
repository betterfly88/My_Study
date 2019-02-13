package designpattern.store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.02.13
 */
public class BookStore extends StorePrototype {
    private String area;
    private List<Book> bookList = new ArrayList<>();

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "area='" + area + '\'' +
                ", bookList=" + bookList +
                '}';
    }

    @Override
    void makeBookList() {
        for (int i=0; i<10 ; i++){
            Book b = new Book();
            b.setSerial(i);
            b.setTitle("Book_"+i);
            this.getBookList().add(b);
        }
    }

    public BookStore clone(){
        BookStore store = new BookStore();
        for(Book b : this.getBookList()){
            store.getBookList().add(b);
        }
        return store;
    }
}
