package performance.test;


import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created by betterFLY on 2018. 6. 13.
 * Github : http://github.com/betterfly88
 */

public class Performance_for {
    static TimerUtil timer = new TimerUtil();
    static int result = 0;


    public static void main (String [] args){
        int max = 100;

        List<Integer> sumArr = new ArrayList<>();
        IntStream.range(0, 20000)
                .forEach(i -> sumArr.add(generator(max)));


//        intStream();
//        for(int i=0; i<10; i++){
//
//        }

        performanceByWhile(sumArr);
        performanceByFor(sumArr);
        performanceByForLoop(sumArr);
        performanceByForEach(sumArr);
        performanceByIterator(sumArr);


    }

    private static List<Integer> intStream(){
        List<Integer> arrList = new ArrayList<>();
        IntStream.range(0, 100)
                .forEach(i -> arrList.add(generator(100)));

        return arrList;
    }

    private static int generator(int max){
        Random random = new Random();
        return random.nextInt(max);
    }

    private static double performanceByWhile(List<Integer> array){
        /*
            while
         */
        System.out.println("while");
        result = 0;

        timer.start();
        int s=0;
//        int size = array.size();
        while(s<array.size()){
            result += array.get(s);
            s++;
        }
        return timer.end();
    }

    private static double performanceByFor(List<Integer> array){
        /*
            for
         */
        System.out.println("basic for");
        result = 0;

        timer.start();
        for(int i=0; i<array.size(); i++){
            result += array.get(i);
        }
        return timer.end();
    }

    private static double performanceByForLoop(List<Integer> array){
        /*
            for loop
         */
        System.out.println("for loop");
        result = 0;

        timer.start();
        for(int temp : array){
            result += temp;
        }
        return timer.end();
    }

    private static double performanceByForEach(List<Integer> array){
        /*
            for each
         */
        System.out.println("for each");
        result = 0;

        timer.start();
        array.forEach((temp) -> {
            result += temp;
        });

        return timer.end();
    }


    private static double performanceByIterator(List<Integer> array){
        /*
            for each
         */
        System.out.println("iterator");
        result = 0;

        timer.start();

        Iterator<Integer> itr = array.iterator();

        while( itr.hasNext() ){
            result += array.get(itr.next());
        }

        return timer.end();
    }

}

class TimerUtil {
    long time;

    public void start(){
        time = System.nanoTime();
    }

    public double end(){
//        System.out.println("compute result : " + (System.nanoTime()-time)/ 1000000.0);
        return (System.nanoTime()-time)/ 1000000.0;
    }
}