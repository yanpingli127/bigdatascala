package com.msb.bigdata.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCountScala {


  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
    conf.setAppName("wordcount")
    conf.setMaster("local")  //单击本地运行

    val sc = new SparkContext(conf)
    //单词统计
    //DATASET
    val fileRDD: RDD[String] = sc.textFile("data/testdata.txt")
    //hello world


    fileRDD.flatMap(  _.split(" ") ).map((_,1)).reduceByKey(  _+_   ).foreach(println)








    //val fileRDD: RDD[String] = sc.textFile("data/testdata.txt")
//    //hello world
//    val words: RDD[String] = fileRDD.flatMap((x:String)=>{x.split(" ")})
//    //hello
//    //world
//    val pairWord: RDD[(String, Int)] = words.map((x:String)=>{new Tuple2(x,1)})
//    //(hello,1)
//    //(hello,1)
//    //(world,1)
//    val res: RDD[(String, Int)] = pairWord.reduceByKey(  (x:Int,y:Int)=>{x+y}   )
//    //X:oldValue  Y:value
//    //(hello,2)
//    //(world,1)
//
//    res.foreach(println)

  }

}
