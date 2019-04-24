package parallel;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by betterfly
 * Date : 2019.04.24
 */

public class ParallelTest {
    final int LIMIT_SIZE = 1000;
    @Test
    public void Parallel_Test(){
        IntStream.rangeClosed(0, 650)
                 .parallel()
                 .forEach(i ->{
                     System.out.println(i * LIMIT_SIZE);

                     try{
                         Thread.sleep(3000);
                     }catch (InterruptedException e){
                         e.printStackTrace();
                     }
                 });
    }
}
