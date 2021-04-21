package com.atguigu.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * mapPartitionsWithIndex 函数说明：
 * 将待处理的数据以分区为单位发送到计算节点进行处理，这里的处理是指可以
 * 进行任意的处理，哪怕是过滤数据，在处理同时可以获取当前分区索引
 */
object Spark03_RDD_Operator_Transform {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]")
      .setAppName("Operator")

    val sc = new SparkContext(sparkConf)

    // TODO 算子 - mapPartitionsWithIndex
    val rdd=sc.makeRDD(List(1,2,3,4),2)

    val mpRDD = rdd.mapPartitionsWithIndex(
      (index,iter) => {
        if(index ==1 ) {
          iter
        }else {
          Nil.iterator
        }
      }
    )
    mpRDD.collect().foreach(println)
    sc.stop()
  }


}
