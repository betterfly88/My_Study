package designpattern.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by betterfly
 * Date : 2019.04.06
 */
public class ListIterator<T> implements Iterator{

    private List<T> list;
    private int size;
    private int currentIndex;

    public ListIterator(List<T> list){
        this.list = list;
        this.size = this.list.size();
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < size;
    }

    @Override
    public T next() {
        T item = this.list.get(this.currentIndex);
        this.currentIndex++;

        return item;
    }

    @Override
    public Object currentItem() {
        return this.list.get(this.currentIndex);
    }
}
