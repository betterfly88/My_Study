package designpattern.slipp;

/**
 * Created by betterfly
 * Date : 2019.01.30
 */
public class Book {
    private int serial;
    private String title;

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
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
                "serial=" + serial +
                ", title='" + title + '\'' +
                '}';
    }
}
