package OOP.StopWatch;

/**
 * Created by betterFLY on 2018. 2. 25.
 * Github : http://github.com/betterfly88
 */

public class StopWatch {
    public long startTime;
    public long stopTime;

    public void start(){
        startTime = System.nanoTime();
    }

    public void stop(){
        stopTime = System.nanoTime();
    }

    public Time getElapsedTime(){
        return new Time(startTime - stopTime);

    }
}