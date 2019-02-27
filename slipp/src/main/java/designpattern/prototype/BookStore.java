package designpattern.prototype;

/**
 * Created by betterfly
 * Date : 2019.02.27
 */
public abstract class BookStore implements Cloneable{
    abstract void bookList();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
