package designpattern.slipp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.01.30
 */
public class BookStore {
    private String name;
    private List<Book> bookList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void makeBook(){
        for(int i=0; i<10; i++){
            Book b = new Book();
            b.setSerial(i);
            b.setTitle("title_"+i);
            this.getBookList().add(b);
        }
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "name='" + name + '\'' +
                ", bookList=" + bookList +
                '}';
    }

    public BookStore clone(){
        BookStore bs = new BookStore();
        for(Book b : this.getBookList()){
            bs.getBookList().add(b);
        }
        return bs;
    }
}
