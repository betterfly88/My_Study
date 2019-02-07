package designpattern.slipp;

/**
 * Created by betterfly
 * Date : 2019.01.30
 */
public class BookMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookStore store = new BookStore();
        store.setName("SLiPP Store");
        store.makeBook();

        BookStore store2 = store.clone();
        store2.setName("chungil store");
        store.getBookList().remove(2);

        System.out.println(store);
        System.out.println(store2);
    }
}