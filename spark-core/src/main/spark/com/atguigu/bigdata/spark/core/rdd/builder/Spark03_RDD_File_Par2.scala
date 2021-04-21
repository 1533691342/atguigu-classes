package com.atguigu.bigdata.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object Spark03_RDD_File_Par2 {

  def main(args: Array[String]): Unit = {


    val sparkConf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("RDD")

    val sc = new SparkContext(sparkConf)
    /**
     * 14 byte /2 =7byte
     * 14/7=2(分区)
     *
     * word.txt 内容：
     * 1234567@@ =》012345678
     * 89@@      =》9101112
     * 0         =》13
     *
     * 偏移量的范围：
     * 【0,7】 =》 第一个分区为：1234567
     * 【7,14】=》 第二个分区为：890
     */

      //如果数据源为多个文件，那么计算分区时以文件为单位进行分区
    val rdd = sc.textFile("datas/word.txt",2)
    rdd.saveAsTextFile("output")




    sc.stop()
  }


}
