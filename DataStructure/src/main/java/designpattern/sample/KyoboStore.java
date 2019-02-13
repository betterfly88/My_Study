package designpattern.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.02.13
 */
public class KyoboStore {
    private String area;
    private List<Book> bookList = new ArrayList<>();

    public void makeBookList(){
        for(int i=0; i<10; i++){
            Book b = new Book();
            b.setSerial(i);
            b.setTitle("book_"+i);
            this.bookList.add(b);
        }
    }
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
        return "KyoboStore{" +
                "area='" + area + '\'' +
                ", bookList=" + bookList +
                '}';
    }

    protected KyoboStore clone() {
        KyoboStore kyobo = new KyoboStore();
        for(Book b : this.getBookList()){
            kyobo.getBookList().add(b);
        }
        return kyobo;
    }
}
