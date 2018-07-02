package com.binaryworks;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class JavaRDDSample {
    public static void main(String[] args){

        //Create a SparkContext to initialize
        SparkConf conf = new SparkConf().setMaster("local").setAppName("Spark RDD Sample");

        // Create a Java version of the Spark Context
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<Integer> numberRDD = sc.parallelize(Arrays.asList(1,2,3,4,5,6,7,8,9,10,12,14,16,18,20,24,28,32,38,46,52));

        // Filter
        JavaRDD<Integer> evenNumberRDD =  numberRDD.filter( (x) -> ((x % 2 == 0) ? true : false));

        List<Integer> evenNumberList = evenNumberRDD.take(40);

        for(Integer evenNum : evenNumberList){
            System.out.print(evenNum + ",");
        }

        // Map Function
        JavaRDD<Integer> doubleNumberRDD = numberRDD.map(x -> (x* 2));

        List<Integer> doubleNumberList = doubleNumberRDD.take(40);

        for(Integer evenNum : doubleNumberList){
            System.out.print(evenNum + ",");
        }

        // Reduce Function
        int sumNumberRDD = numberRDD.reduce((x, y) -> (x + y));

        System.out.println("Sum : " + sumNumberRDD);
    }
}