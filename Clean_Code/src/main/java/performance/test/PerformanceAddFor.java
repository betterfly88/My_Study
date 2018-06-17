package performance.test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by betterFLY on 2018. 6. 13.
 * Github : http://github.com/betterfly88
 */

public class PerformanceAddFor {
    static TimerUtil timer = new TimerUtil();
    static int result = 0;


    public static void main (String [] args){
        int max = 100;

        List<Integer> sumArr = intStream();
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