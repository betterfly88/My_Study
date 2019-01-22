package designpattern;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2018.12.29
 */
public class ListClientExample {
    private List list;

    public ListClientExample(){
        list = new LinkedList();
    }

    private List getList(){
        return this.list;
    }

    public static void main(String[] args) {
        ListClientExample lce = new ListClientExample();
        List list = lce.getList();
        System.out.println(list);
    }
}
