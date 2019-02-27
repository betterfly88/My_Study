package practice.prototype;

import designpattern.prototype.book.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.02.27
 */
public class BookStore implements Cloneable {
    private String name;
    private List<Book> bookList = new ArrayList<>();

    public void makeBookList(){
        for(int i=0; i<10; i++){
            Book b = new Book();
            b.setBookName("Book_"+i);
            b.setBookdId(i);
            this.getBookList().add(b);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
