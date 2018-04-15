package OOP.StopWatch;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


/**
 * Created by betterFLY on 2018. 2. 25.
 * Github : http://github.com/betterfly88
 */

public class StopWatchTest {
    public long expectedElapsedTime = 100l;

    @Test
    public void should_return_elapsed_millis_second(){
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        doSomeThing();

        stopWatch.stop();

        Time time = stopWatch.getElapsedTime();

        Assertions.assertThat(time.getMillisTime()).isGreaterThanOrEqualTo(expectedElapsedTime);

    }

    // 객체지향으로 구현할 경우 이처럼 실제 기능이 변경되는 부분(getNanoTime())만 변경하면 된다
    @Test
    public void should_return_elapsed_nano_second(){
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        doSomeThing();

        stopWatch.stop();

        Time time = stopWatch.getElapsedTime();

        Assertions.assertThat(time.getNanoTime()).isGreaterThanOrEqualTo(expectedElapsedTime);

    }

    private void doSomeThing(){
        try{
            Thread.sleep(expectedElapsedTime);
        }catch(InterruptedException e){
            e.getMessage();
        }
    }
}
