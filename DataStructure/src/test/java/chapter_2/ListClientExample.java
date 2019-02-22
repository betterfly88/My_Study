package chapter_2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.01.05
 */
public class ListClientExample{
    @SuppressWarnings("rawtypes")
    private List list;

    @SuppressWarnings("rawtypes")
    public ListClientExample(){
        list = new LinkedList();
    }

    @SuppressWarnings("rawtypes")
    public List getList(){
        return this.list;
    }

    public static void main(String[] args) {
//        token.chapter_2.ListClientExample lce
    }
}
