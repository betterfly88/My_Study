package designpattern.prototype.book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.01.27
 */
public class BookShop implements Cloneable{
    private String shopName;
    List<Book> books = new ArrayList<>();

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                "books@" + books.hashCode() + '\'' +
                ", books=" + books +
                '}';
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public void loadData(){
        for (int i=0; i<10; i++){
            Book b = new Book();
            b.setBookdId(i);
            b.setBookName("Books "+i);
            getBooks().add(b);
        }
    }

    // 얕은 복사
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    // 깊은 복사
    @Override
    public BookShop clone(){
         BookShop bs = new BookShop();

        for(Book b : this.getBooks()){
            bs.getBooks().add(b);
        }
         return bs;
    }
}
