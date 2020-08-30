package com.wemakeprice.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

/*
    https://www.javaworld.com/article/2972863/open-source-java-projects-apache-spark.html
    https://learning.oreilly.com/library/view/learning-spark-2nd/9781492050032/ch01.html
 */
public class WordCount {
    public void readFile(String filePath){
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("Spark with betterFLY");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        JavaRDD<String> textFile = sc.textFile(filePath);

        JavaPairRDD<String, Integer> counts =
                textFile.flatMap(s -> Arrays.asList(s.split(" ")).iterator())
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a,b) -> a+b);

        counts.saveAsTextFile("/Users/betterfly/dev/repository/my-study/My_Study/learning-spark/result");

    }
}
