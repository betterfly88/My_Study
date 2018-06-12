package performance.test;


import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by betterFLY on 2018. 6. 13.
 * Github : http://github.com/betterfly88
 */

public class Performance_for {
    static TimerUtil timer = new TimerUtil();
    static int result = 0;


    public static void main (String [] args){
        int max = 100;

//        int array[] = new int[100];
        int array[] = new int[100];
        Arrays.setAll(array, i -> {
            return generator(max);
        });

        List<Integer> arrayList = Arrays.asList(array);

        intStream();
//        performanceByWhile(array);
//        performanceByFor(array);
//        performanceByForEach(array);
    }

    private static void intStream(){
//        IntStream is = new Random().ints();

        Stream<Integer> st = Stream.generate(()->1);
        System.out.println(st.toArray());

//        is.limit(100).forEach(System.out::println);
    }

    private static int generator(int max){
        Random random = new Random();
        return random.nextInt(max);
    }

    private static double performanceByWhile(int[] array){
        /*
            while
         */
        System.out.println("while");
        result = 0;

        timer.start();
        int s=0;
        while(s<array.length){
            result += array[s];
            s++;
        }
        return timer.end();
    }

    private static double performanceByFor(int[] array){
        /*
            for
         */
        System.out.println("basic for");
        result = 0;

        timer.start();
        for(int i=0; i<array.length; i++){
            result += array[i];
        }
        return timer.end();
    }

    private static double performanceByForLoop(int[] array){
        /*
            for loop
         */
        System.out.println("for each");
        result = 0;

        timer.start();
        for(int temp : array){
            result += temp;
        }
        return timer.end();
    }

    private static double performanceByForEach(int[] array){
        /*
            for each
         */
        System.out.println("for each");
        result = 0;

        timer.start();
//        array.forEach((temp) -> {
//            System.out.println(temp);
//        });

        return timer.end();
    }


    private static double performanceByIterator(int[] array){
        /*
            for each
         */
        System.out.println("for each");
        result = 0;

        timer.start();
        List<Integer> list = new ArrayList<>();

        Iterator<Integer> itr = list.iterator();

        while( itr.hasNext() ){
            list.get( itr.next() );
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
        System.out.println("compute result : " + (System.nanoTime()-time)/ 1000000000.0);
        return (System.nanoTime()-time)/ 1000000000.0;
    }
}