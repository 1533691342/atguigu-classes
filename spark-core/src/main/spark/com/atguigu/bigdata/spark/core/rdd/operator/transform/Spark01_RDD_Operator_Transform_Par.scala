package com.atguigu.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * map 函数说明：
 * 将处理的数据逐条进行映射转换，这是的转换可以是类型的转换，也可以是
 * 值的转换
 * def map[U:ClassTag](T => U):RDD[U]
 */
object Spark01_RDD_Operator_Transform_Par {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]")
      .setAppName("Operator")

    val sc = new SparkContext(sparkConf)


    /**
     * 1、rdd 的计算一个分区内数据 是一个一个的执行逻辑，
     * 只有前面一个数据全部的逻辑执行完毕之后才会执行下一个数据，
     * 分区内数据的执行时有序的
     * 2、不同的分区数据计算是无序的
     *
     *
     */
    val rdd = sc.makeRDD(List(1, 2, 3, 4),1)
    var mapRDD=rdd.map(
      num =>{
        println(">>>>>>>>>>>" +num)
        num
      }
    )

    var mapRDD1=mapRDD.map(
      num =>{
        println("#########" +num)
        num
      }
    )

    mapRDD1.collect()

    sc.stop()
  }

}
