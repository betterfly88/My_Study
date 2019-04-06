package designpattern.iterator;

/**
 * Created by betterfly
 * Date : 2019.04.06
 */
public interface Iterator<T> {
    abstract boolean hasNext();
    abstract T next();
}
