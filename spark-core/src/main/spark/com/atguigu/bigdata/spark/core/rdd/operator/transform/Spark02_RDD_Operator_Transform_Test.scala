package com.atguigu.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * map 和 mapPartitions 的区别：
 * 数据处理角度：
 * map 算子是分区内一个数据一个数据的执行，类似于串行操作
 * mapPartitions 算子 是以分区为单位进行批处理操作
 * 功能角度：
 * map 主要目的是将数据源中的数据进行转换和改变，但是不会减少或增多数据；
 * mapPartitions 需要传递一个迭代器，返回一个迭代器，没有要求的元素的
 * 个数保持不变，可以减少或增加数据
 *性能角度：
 *  map 算子类似于串行，性能较低
 *  mapPartitions 类似于批处理，性能高
 *  但是 mapPartitions 会长时间占用内存，会导致内存溢出
 */
/**
 * 获取每个数据分区的最大值
 *
 */
object Spark02_RDD_Operator_Transform_Test {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]")
      .setAppName("Operator")

    val sc = new SparkContext(sparkConf)

    // TODO 算子 - mapPartitions
    val rdd=sc.makeRDD(List(1,2,3,4),2)
    /**
     * [1,2]  [3,4] =>[2]   [4]
     *
     */
    val mpRDD=rdd.mapPartitions(
      iter =>{
        List(iter.max).iterator
      }
    )
    mpRDD.collect().foreach(println)

    sc.stop()
  }

}
