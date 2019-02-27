package designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.02.27
 */
public class Kyobo extends BookStore{
    private String area;
    private List<Book> bookList = new ArrayList<Book>();

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

    public Kyobo clone(){
        Kyobo k = new Kyobo();
        for(Book b : this.getBookList()){
            k.getBookList().add(b);
        }

        return k;
    }

    @Override
    public String toString() {
        return "Kyobo{" +
                "area='" + area + '\'' +
                ", bookList=" + bookList +
                '}';
    }

    void bookList() {
        for(int i=0; i<10; i++){
            Book book = new Book();
            book.setSerial(i);
            book.setTitle("책_"+i);
            this.getBookList().add(book);
        }
    }
}
