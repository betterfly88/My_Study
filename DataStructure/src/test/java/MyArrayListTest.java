/**
 * Created by betterfly
 * Date : 2019.02.03
 */
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import tds.chapter_2.MyArrayList;

/**
 * @author downey
 *
 */
public class MyArrayListTest {

    protected List<Integer> mylist;
    protected List<Integer> list;


    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        mylist = new MyArrayList<>();
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
//        mylist.addAll(list);
    }

    /**
     * Test method for {@link MyArrayList#MyArrayList()}.
     */
    @Test
    public void testMyList() {
        assertThat(mylist.size(), is(3));
    }

    /**
     * Test method for {@link MyArrayList#add(Object)}.
     */
    @Test
    public void testAddT() {
        for (int i = 4; i < 20; i++) {
            mylist.add(i);
        }
        //System.out.println(Arrays.toString(mal.toArray()));
        assertThat(mylist.get(18), is(new Integer(19)));
    }


    /**
     * Test method for {@link MyArrayList#get(int)}.
     */
    @Test
    public void testGet() {
        assertThat(mylist.get(1), is(new Integer(2)));
    }

    /**
     * Test method for {@link MyArrayList#indexOf(Object)}.
     */
    @Test
    public void testIndexOf() {
        assertThat(mylist.indexOf(1), is(0));
        assertThat(mylist.indexOf(2), is(1));
        assertThat(mylist.indexOf(3), is(2));
        assertThat(mylist.indexOf(4), is(-1));

        assertThat(mylist.indexOf(7), is(-1));
//        assertThat(mylist.indexOf(1), is(3));

    }

    /**
     * Test method for {@link MyArrayList#lastIndexOf(Object)}.
     */
    @Test
    public void testLastIndexOf() {
        mylist.add(2);
        assertThat(mylist.lastIndexOf(new Integer(2)), is(3));
    }

    /**
     * Test method for {@link MyArrayList#remove(Object)}.
     */
    @Test
    public void testRemoveObject() {
        boolean flag = mylist.remove(new Integer(2));
        assertThat(flag, equalTo(true));
        assertThat(mylist.size(), is(2));
        assertThat(mylist.get(1), is(new Integer(3)));
        //System.out.println(Arrays.toString(mal.toArray()));

        flag = mylist.remove(new Integer(1));
        assertThat(flag, equalTo(true));
        assertThat(mylist.size(), is(1));
        assertThat(mylist.get(0), is(new Integer(3)));
        //System.out.println(Arrays.toString(mal.toArray()));

        flag = mylist.remove(new Integer(5));
        assertThat(flag, equalTo(false));
        assertThat(mylist.size(), is(1));
        assertThat(mylist.get(0), is(new Integer(3)));
        //System.out.println(Arrays.toString(mal.toArray()));

        flag = mylist.remove(new Integer(3));
        assertThat(flag, equalTo(true));
        assertThat(mylist.size(), is(0));
        //System.out.println(Arrays.toString(mal.toArray()));
    }

    /**
     * Test method for {@link MyArrayList#remove(int)}.
     */
    @Test
    public void testRemoveInt() {
        Integer val = mylist.remove(1);
        assertThat(val, is(new Integer(2)));
        assertThat(mylist.size(), is(2));
        assertThat(mylist.get(1), is(new Integer(3)));
    }

    /**
     * Test method for {@link MyArrayList#removeAll(java.util.Collection)}.
     */
    @Test
    public void testRemoveAll() {
        mylist.removeAll(list);
        assertThat(mylist.size(), is(0));
    }

    /**
     * Test method for {@link MyArrayList#set(int, Object)}.
     */
    @Test
    public void testSet() {
        Integer val = mylist.set(1, 5);
        assertThat(val, is(new Integer(2)));

        val = mylist.set(0, 6);
        assertThat(val, is(new Integer(1)));

        val = mylist.set(2, 7);
        assertThat(val, is(new Integer(3)));

        val = mylist.set(3, 11);
        assertThat(val, is(new Integer(4)));

        // return value should be 2
        // list should be [6, 5, 7]
        assertThat(mylist.get(0), is(new Integer(6)));
        assertThat(mylist.get(1), is(new Integer(5)));
        assertThat(mylist.get(2), is(new Integer(7)));
        assertThat(mylist.get(3), is(new Integer(11)));
//        assertThat(mylist.get(3), is(new Integer(9)));
        //System.out.println(Arrays.toString(mal.toArray()));

        try {
            mylist.set(-1, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {} // good

        try {
            mylist.set(4, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {} // good
    }

    /**
     * Test method for {@link MyArrayList#add(int, Object)}.
     */
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
