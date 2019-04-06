package designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.04.06
 */
public class BookShelf implements Aggregate {
    private List<Book> bookList;

    public BookShelf(){
        this.bookList = new ArrayList<>();
    }

    public Book getBookAt(int index){
        return this.bookList.get(index);
    }

    public void appendBook(Book book){
        this.bookList.add(book);
    }

    public int bookListSize(){
        return this.bookList.size();
    }
    @Override
    public Iterator iterator() {
        return new ListIterator<Book>(this.bookList);
    }
}
