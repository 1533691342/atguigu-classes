package com.atguigu.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


/**
 * 从服务器日志数据 apache.log 中获取用户请求 url 资源路径
 *
 */
object Spark01_RDD_Operator_Transform_Test {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]")
      .setAppName("Operator")

    val sc = new SparkContext(sparkConf)

    val rdd = sc.textFile("datas/apache.log")

    //长字符串转换为短字符串
    val  mapRDD:RDD[String]= rdd.map(
      line => {
        val datas = line.split(" ")
        datas(6)
      }
    )
    mapRDD.collect().foreach(println)



    sc.stop()
  }

}
