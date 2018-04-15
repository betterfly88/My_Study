package OOP.StopWatch;

import org.junit.Test;

import org.assertj.core.api.Assertions;


/**
 * Created by betterFLY on 2018. 2. 25.
 * Github : http://github.com/betterfly88
 */

public class ProceduralStopWatchTest {
    public long expectedElapsedTime = 100l;

    @Test
    public void should_return_elapsed_millis_second(){
        ProceduralStopWatch stopWatch = new ProceduralStopWatch();

        stopWatch.startTime = System.currentTimeMillis();

        doSomeThing();

        stopWatch.stopTime = System.currentTimeMillis();

        long elapsedTime = stopWatch.getElapsedTime();

        Assertions.assertThat(elapsedTime).isGreaterThanOrEqualTo(expectedElapsedTime);
    }

    // millis 단위의 스탑워치에서 nano 단위의 스탑워치를 구현하고자 한다면 아래와 같이 모든 변수 및 메서드가 변경되어야한다.
    // 결국 요구사항 변경이 데이터 구조의 변경을 유발시킨다
    // >> 데이터를 사용하는 모든 코드의 변경이 될 수 밖에 없다.
    @Test
    public void should_return_elapsed_nano_second(){
        ProceduralStopWatch stopWatch = new ProceduralStopWatch();

        stopWatch.startNanoTime = System.nanoTime();

        doSomeThing();

        stopWatch.stopNanoTime = System.nanoTime();

        long elapsedTime = stopWatch.getElapsedNanoTime();

        Assertions.assertThat(elapsedTime).isGreaterThanOrEqualTo(expectedElapsedTime);
    }

    private void doSomeThing(){
        try{
            Thread.sleep(expectedElapsedTime);
        }catch(InterruptedException e){
            e.getMessage();
        }
    }
}
