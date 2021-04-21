package com.atguigu.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Spark04_RDD_Operator_Transform1 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]")
      .setAppName("Operator")

    val sc = new SparkContext(sparkConf)

    // TODO 算子 - mapPartitionsWithIndex
    val rdd:RDD[String]=sc.makeRDD(
      List("hello scala","hello spark")
    )

    val flatRDD :RDD[String] = rdd.flatMap(
      s => {
        s.split(" ")
      }
    )
    flatRDD.collect().foreach(println)
    sc.stop()
  }


}
