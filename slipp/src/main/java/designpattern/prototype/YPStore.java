package designpattern.prototype;

/**
 * Created by betterfly
 * Date : 2019.02.14
 */
public class YPStore extends BookStore{
    protected void makeBookList() {
        for(int i=0; i<100; i++){
            Book b = new Book();
            b.setTitle(i+"Book");
            b.setSerail(i);
            super.getBookList().add(b);
        }
    }
}
