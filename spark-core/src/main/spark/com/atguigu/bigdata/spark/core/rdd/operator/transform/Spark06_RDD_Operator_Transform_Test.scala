package com.atguigu.bigdata.spark.core.rdd.operator.transform

import java.text.SimpleDateFormat

import org.apache.spark.{SparkConf, SparkContext}


object Spark06_RDD_Operator_Transform_Test {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]")
      .setAppName("Operator")

    val sc = new SparkContext(sparkConf)

    val rdd = sc.textFile("datas/apache.log")
    val timeRDD = rdd.map(
      line => {
        val datas = line.split(" ")
        val times = datas(3)
        val sdf = new SimpleDateFormat("dd/MM/yyy:HH:mm:ss")
        val date = sdf.parse(times)
        val sdf1 = new SimpleDateFormat("HH")
        val hour: String = sdf1.format(date)
        (hour, 1)
      }
    ).groupBy(_._1)
    timeRDD.map{
      case (hour,iter) =>{
        (hour,iter.size)
      }
    }.collect().foreach(println)


    sc.stop()


  }



}
