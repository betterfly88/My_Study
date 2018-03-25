package OOP.StopWatch;

import static java.lang.Math.pow;

/**
 * Created by betterFLY on 2018. 2. 25.
 * Github : http://github.com/betterfly88
 */

public class Time {

    private long nano;

    public Time (long nano){
        this.nano = nano;
    }

    public long getMillisTime(){
        return (long)(nano / pow(10,6));
    }


    public long getNanoTime(){
        return nano;
    }
}
