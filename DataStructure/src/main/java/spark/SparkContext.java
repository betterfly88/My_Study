package spark;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by betterfly
 * Date : 2019.04.19
 */
public class SparkContext {
    public void executeSparkContext(){
        JavaSparkContext sc = new JavaSparkContext();

        JavaRDD<String> lines = sc.textFile("/sample.txt").flatMap(
                new FlatMapFunction<String, String>() {
                    public Iterator<String> call(String s) {
                        return (Iterator<String>) Arrays.asList(s.split(" "));
                    }
                }
        );

    }
}
