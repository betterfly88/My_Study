package chapter_3;

import chapter_2.MyArrayListTest;
import org.junit.Before;
import org.junit.Test;
import tds.chapter_3.MyLinkedList;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by betterfly
 * Date : 2019.02.17
 */
public class MyLinkedListTest {
    MyLinkedList mylist;

    @Before
    public void setUp() throws Exception {
        mylist = new MyLinkedList<Integer>();
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
    }

    @Test
    public void testIndexOf() {
        assertThat(mylist.indexOf(1), is(0));
        assertThat(mylist.indexOf(2), is(1));
        assertThat(mylist.indexOf(3), is(2));
        assertThat(mylist.indexOf(4), is(-1));
        assertThat(mylist.indexOf("aaa"), is(-1));
        assertThat(mylist.indexOf(7), is(-1));
    }
}
