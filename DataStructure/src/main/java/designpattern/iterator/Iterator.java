package designpattern.iterator;

/**
 * Created by betterfly
 * Date : 2019.04.06
 */
public interface Iterator<T> {
    boolean hasNext();
    T next();
    T currentItem();
}
