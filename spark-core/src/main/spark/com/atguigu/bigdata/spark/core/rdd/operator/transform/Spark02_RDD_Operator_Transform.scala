package com.atguigu.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * mapPartitions:
 * def mapPartitions[U:ClsaaTag](
 * f:Iterator[T] => Iterator[U]
 * preservesPartitioning:Boolean =false):RDD[U]
 * 说明：
 * 可以以分区为单位进行数据转换操作，
 * 但是会将整个分区的数据加载到内存中进行引用
 * 如果处理完的数据不会被释放掉，存在对象的引用。
 * 在内存较小，数据量较大的场合下，会导致内存溢出
 */
object Spark02_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]")
      .setAppName("Operator")

    val sc = new SparkContext(sparkConf)

    // TODO 算子 - mapPartitions
    val rdd=sc.makeRDD(List(1,2,3,4),2)

    val mpRDD = rdd.mapPartitions(
      iter => {
        println(">>>>>>>")
        iter.map(_ * 2)
      }
    )

    mpRDD.collect().foreach(println)
    sc.stop()
  }


}
