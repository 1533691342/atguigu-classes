package com.atguigu.bigdata.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}


object Spark02_RDD_File1 {
  def main(args: Array[String]): Unit = {


  val  sparkConf=new SparkConf()
    .setMaster("local[*]")
    .setAppName("RDD")

  val sc = new SparkContext(sparkConf)

    //从文件中创建 RDD ，将文件中的数据作为处理的数据源

    // textFile : 以行为单位来读取数据 ，读取的数据都是字符串
    // wholeTextFiles ：以文件为单位读取数据
    // 读取的结果 表示为 元组，第一个元素表示文件路径，第二个元素表示文件的内容
    val rdd = sc.wholeTextFiles("datas")
    rdd.collect().foreach(println)


  sc.stop()
}

}
