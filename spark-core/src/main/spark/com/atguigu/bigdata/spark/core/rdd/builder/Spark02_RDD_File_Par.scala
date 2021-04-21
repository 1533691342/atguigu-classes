package com.atguigu.bigdata.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object Spark02_RDD_File_Par {
  def main(args: Array[String]): Unit = {


    val sparkConf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("RDD")

    val sc = new SparkContext(sparkConf)

    // textFile 可以将文件作为数据处理的数据源，默认也可以设定分区
    // minPartitions：最小分区数量
    // math.min(defaultParallelism,2)
    // val rdd = sc.textFile("datas/1.txt")
    //如果不行使用默认分区数量，可以通过第二个参数指定分区数
    // spark 读取文件，底层其实使用的就是 hadoop 的读取方式
    //分区数量的计算方式：
    // totalSize = 7
    // goalSize = 7 / 2 = 3 (byte)

    val rdd = sc.textFile("datas/1.txt",3)
    rdd.saveAsTextFile("output")




    sc.stop()
  }
}
