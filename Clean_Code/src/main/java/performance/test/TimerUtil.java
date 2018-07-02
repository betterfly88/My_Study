package performance.test;

/**
 * Created by betterFLY on 2018. 7. 1.
 * Github : http://github.com/betterfly88
 */

public class TimerUtil {
    long time;

    public void start(){
        time = System.nanoTime();
    }

    public double end(){
    //        System.out.println("compute result : " + (System.nanoTime()-time)/ 1000000.0);
        return (System.nanoTime()-time)/ 1000000.0;
    }
}

