package tds;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.01.29
 */
public class ListClientExample {

    private List list;

    public ListClientExample() {
        list = new LinkedList();
    }

    public List getList() {
        return list;
    }

    public static void main(String[] args) {
        ListClientExample lce = new ListClientExample();
        List list = lce.getList();
        System.out.println(list);
    }
}
