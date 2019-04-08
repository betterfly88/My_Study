package iterator;

import designpattern.iterator.Book;
import designpattern.iterator.BookShelf;
import designpattern.iterator.Iterator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.04.06
 */
public class IteratorTest {

    @Test
    public void 반복자_패턴(){
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("자바로 배우는 핵심 알고리즘"));
        bookShelf.appendBook(new Book("GoF 디자인 패턴"));
        bookShelf.appendBook(new Book("함께 자라기"));

        Iterator<Book> iterator = bookShelf.iterator();

        while(iterator.hasNext()){
            Book book = iterator.next();
            System.out.println(book.getTitle());
        }
    }
}
