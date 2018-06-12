package OOP.StopWatch;

/**
 * Created by betterFLY on 2018. 2. 25.
 * Github : http://github.com/betterfly88
 */

public class ProceduralStopWatch {
    public long startTime;
    public long stopTime;

    public long getElapsedTime(){
        return startTime - stopTime;
    }

    /*
        기존에 기본  startTime의 스탑워치를 구현 중에
        nano단위의 시간으로 스탑워치를 구현한다면
     */
    public long startNanoTime;
    public long stopNanoTime;

    public long getElapsedNanoTime(){
        return startNanoTime - stopNanoTime;
    }
}
