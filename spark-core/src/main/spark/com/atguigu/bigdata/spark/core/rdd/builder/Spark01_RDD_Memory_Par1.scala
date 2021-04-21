package com.atguigu.bigdata.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Memory_Par1 {
  def main(args: Array[String]): Unit = {
    val  sparkConf=new SparkConf().setMaster("local[*]").setAppName("RDD")

    val sc = new SparkContext(sparkConf)

    /**
     * 数据的存放：
     * 【1,2】，【3,4】
     */
//   val rdd = sc.makeRDD(List(1, 2, 3, 4),2) //2个分区
    /**
     * 数据的存放：
     * 【1】，【2】，【3,4】
     */
//   val rdd = sc.makeRDD(List(1, 2, 3, 4),3) //3个分区

    /**
     * 数据的存放：
     * 【1】，【2,3】，【4,5】
     */
   val rdd = sc.makeRDD(List(1, 2, 3, 4,5),3) //3个分区

    // 将处理的数据保存成 分区文件
    rdd.saveAsTextFile("output")

    sc.stop()
  }

}
