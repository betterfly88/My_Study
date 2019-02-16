package designpattern.prototype;

/**
 * Created by betterfly
 * Date : 2019.02.14
 */
public class Book {
    private int serail;
    private String title;

    public int getSerail() {
        return serail;
    }

    public void setSerail(int serail) {
        this.serail = serail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "serail=" + serail +
                ", title='" + title + '\'' +
                '}';
    }
}
