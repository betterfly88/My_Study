package designpattern.store;

import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.02.13
 */
public abstract class StorePrototype implements Cloneable{
    abstract void makeBookList();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
