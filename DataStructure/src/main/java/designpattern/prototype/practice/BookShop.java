package designpattern.prototype.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.01.27
 */
public class BookShop implements Cloneable{
    private String shopName;
    private List<Book> list = new ArrayList<>();

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", list@" + list.hashCode() + '\'' +
                ", list" + list+
                '}';
    }

    public void loadData(){
        for (int i=0; i<10; i++){
            Book book = new Book();
            book.setBookId(i);
            book.setBookName("Book_"+i);
            list.add(book);
        }
    }
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    @Override
    protected BookShop clone() throws CloneNotSupportedException {
        BookShop bs = new BookShop();
        for(Book b : this.getList()){
            bs.getList().add(b);
        }
        return bs;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
}