package designpattern.prototype.book;

/**
 * Created by betterfly
 * Date : 2019.01.27
 */
public class Book {

    private int bookdId;
    private String bookName;

    @Override
    public String toString() {
        return "Books{" +
                "bookdId=" + bookdId +
                ", bookName='" + bookName + '\'' +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookdId() {
        return bookdId;
    }

    public void setBookdId(int bookdId) {
        this.bookdId = bookdId;
    }
}
