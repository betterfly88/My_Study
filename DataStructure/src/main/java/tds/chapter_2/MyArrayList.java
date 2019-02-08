package tds.chapter_2;

import java.util.*;

/**
 * Created by betterfly
 * Date : 2019.02.03
 */
public class MyArrayList<T> implements List<T> {
    private int size;
    private T [] array;
    private final int DEFAULT_CAPACITY = 1;

    @SuppressWarnings("unchecked")
    public MyArrayList(){
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "size=" + size +
                ", array=" + Arrays.toString(array) +
                ", DEFAULT_CAPACITY=" + DEFAULT_CAPACITY +
                '}';
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T element) {
        if(size >= array.length){
            T[] bigger = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }

        array[size] = element;
        size ++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int idx = indexOf(o);
        if(idx == -1){
            return false;
        }
        remove(idx);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = false;

        for(Object o : c){
            flag  &= remove(o);
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    @Override
    public T set(int index, T element) {
        T prevValue = get(index);
        array[index] = element;
        return prevValue;
    }


//    @Override
//    public void add(int index, T element) {
//        if (index < 0 || index > size) {
//            throw new IndexOutOfBoundsException();
//        }
//        // add the element to get the resizing
//        add(element);
//
//        // shift the elements
//        for (int i=size-1; i>index; i--) {
//            array[i] = array[i-1];
//        }
//        // put the new one in the right place
//        array[index] = element;
//    }

    @Override
    public void add(int index, T element) {
        if(add(element)) {
            for (int i = size; i <= index; i--) {
                array[i] = array[i - 1];
            }

            array[index] = element;
        }
    }


    @Override
    public T remove(int index) {
        T prevVal = get(index);
        for(int i=index; i<size-1; i++){
            array[i] = array[i+1];
        }

        size --;

        return prevVal;
    }

    /*
        (o==null ? get(i)==null : o.equals(get(i)))

        Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
        More formally, returns the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.

        Parameters:
        o - element to search for

        Returns:
        the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
//    @Override
//    public int indexOf(Object o) {
//        for(int i=0; i<array.length; i++){
////            if(array[i].equals(o)){
//            if(array[i] == o){
//                return i;
//            }
//        }
//
//        return -1;
//    }

    @Override
    public int indexOf(Object target) {
        for (int i = 0; i<size; i++) {
            if (equals(target, array[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
