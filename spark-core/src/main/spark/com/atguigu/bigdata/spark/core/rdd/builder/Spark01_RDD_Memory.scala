package com.atguigu.bigdata.spark.core.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Memory {
  def main(args: Array[String]): Unit = {
    val  sparkConf=new SparkConf().setMaster("local[*]").setAppName("RDD")

    val sc = new SparkContext(sparkConf)

    //从内存中创建rdd，将内存中集合的数据作为处理的数据源
    val seq = Seq[Int](1, 2, 3, 4)
    //parallelize ：并行
//    val rdd :RDD[Int]= sc.parallelize(seq) 等同于  val rdd = sc.makeRDD(seq)
val rdd = sc.makeRDD(seq)

    rdd.collect().foreach(println)

    sc.stop()
  }

}
