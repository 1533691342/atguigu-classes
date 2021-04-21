package com.atguigu.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Spark01_RDD_Operator_Transform_Part {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]")
      .setAppName("Operator")

    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1, 2, 3, 4), 2)
    rdd.saveAsTextFile("output")
    val mapRDD = rdd.map(_ * 2)

    mapRDD.saveAsTextFile("output1")
    sc.stop()
  }

}
