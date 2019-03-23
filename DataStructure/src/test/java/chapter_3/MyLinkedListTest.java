package chapter_3;

import chapter_2.MyArrayListTest;
import org.junit.Before;
import org.junit.Test;
import tds.chapter_3.MyLinkedList;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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
        assertThat(mylist.indexOf(null), is(-1));
        assertThat(mylist.indexOf(7), is(-1));
    }

    @Test
    public void testAddIntT() {
        mylist.add(1, 5);
        //System.out.println(Arrays.toString(mal.toArray()));
        assertThat(mylist.get(1), is(new Integer(5)));
        assertThat(mylist.size(), is(4));

        try {
            mylist.set(-1, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {} // good

        try {
            mylist.set(4, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {} // good

        mylist.add(0, 6);
        //System.out.println(Arrays.toString(mal.toArray()));
        assertThat(mylist.get(0), is(6));

        mylist.add(5, 7);
        //System.out.println(Arrays.toString(mal.toArray()));
        assertThat(mylist.get(5), is(new Integer(7)));
    }
}
