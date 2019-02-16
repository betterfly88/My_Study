package designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.02.14
 */
public class KyoboStore extends BookStore{
    public void makeBookList() {
        for(int i=0; i<10; i++){
            Book b = new Book();
            b.setSerail(i);
            b.setTitle("Title_"+i);
            super.getBookList().add(b);
        }
    }
}
