package designpattern.store;

/**
 * Created by betterfly
 * Date : 2019.02.13
 */
public class BookDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookStore bookStore = new BookStore();
        bookStore.setArea("강남_1호점");
        bookStore.makeBookList();

        BookStore bookstore2 = (BookStore)bookStore.clone();
        bookstore2.setArea("강남_2호점");

        bookStore.getBookList().remove(1);
        System.out.println(bookStore);
        System.out.println(bookstore2);

    }
}
