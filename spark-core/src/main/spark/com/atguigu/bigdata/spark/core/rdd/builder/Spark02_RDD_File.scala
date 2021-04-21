package com.atguigu.bigdata.spark.core.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark02_RDD_File {
  def main(args: Array[String]): Unit = {
    val  sparkConf=new SparkConf()
      .setMaster("local[*]")
      .setAppName("RDD")

    val sc = new SparkContext(sparkConf)

    //从文件中创建rdd，将内存中集合的数据作为处理的数据源
    // path 路径默认以当前环境的根路径为基准，可以写绝对路径，也可以写相对路径
    val rdd :RDD[String]= sc.textFile("datas/1.txt")
    // path 路径可以是文件的具体路径，也可以是目录名称 sc.textFile("datas")
    // path 路径还可以使用通配符 * 号  ：sc.textFile("datas/1*.txt")
    // path 还可以是分布式存储系统路径：HDFS
    rdd.collect().foreach(println)

    sc.stop()
  }
}
