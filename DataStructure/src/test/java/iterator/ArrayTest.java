package iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by betterfly
 * Date : 2019.04.10
 */
public class ArrayTest {

    @Test
    public void List_테스트(){
        // given
        List<String> arr = new ArrayList();
        arr.add("a");
        arr.add("b");
        arr.add("c");

        //then
        for(int i=0; i<arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }

    @Test
    public void Array_테스트(){
        // given
        String [] arr = {"a", "b", "c"};

        //then
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    @Test
    public void Queue_테스트(){
        Queue queue = new LinkedBlockingQueue();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
