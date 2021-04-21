package com.atguigu.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * 要求：
 * 写出 List(1,2,3,4)  都在哪个分区中
 */

object Spark03_RDD_Operator_Transform1 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]")
      .setAppName("Operator")

    val sc = new SparkContext(sparkConf)

    // TODO 算子 - mapPartitionsWithIndex
    val rdd=sc.makeRDD(List(1,2,3,4))
   val mpRDD= rdd.mapPartitionsWithIndex(
      (index,iter) =>{
        iter.map(
          num =>{
            (index,num)
          }
        )
      }
    )


    mpRDD.collect().foreach(println)
    sc.stop()
  }


}
