package com.atguigu.bigdata.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object Spark02_RDD_File_Par1 {
  def main(args: Array[String]): Unit = {


    val sparkConf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("RDD")

    val sc = new SparkContext(sparkConf)
    /**
     * 数据分区的分配
     * 1、数据以行为单位进行读取的
     *    spark 读取文件，采用的是 hadoop 的方式读取，所以一行一行的读取，和字节数没有关系
     * 2、数据读取时以偏移量为单位的，偏移量不会被重复读取
     * 3、数据分区的偏移量范围计算：
     * 每个都是3个字节
     * 0号分区 =》偏移量为【0,3】 =》12
     * 1号分区=》偏移量【3,6】=》3
     * 2号分区=》偏移量【6,7】=》
     */

    val rdd = sc.textFile("datas/1.txt",3)
    rdd.saveAsTextFile("output")




    sc.stop()
  }

}
