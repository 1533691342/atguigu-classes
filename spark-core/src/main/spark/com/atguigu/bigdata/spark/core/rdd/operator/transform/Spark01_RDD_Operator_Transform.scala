package com.atguigu.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Operator_Transform {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]")
      .setAppName("Operator")

    val sc = new SparkContext(sparkConf)

    // TODO 算子 - map
    val rdd=sc.makeRDD(List(1,2,3,4))

    /**
     * 1,2,3,4
     * 2,4,6,8
     */
      //转换函数
    def mapFunction(num:Int): Int ={
      num * 2
    }

//    val mapRDD = rdd.map(mapFunction)
    //简写如下：
//    val mapRDD = rdd.map(
//      (num:Int)=>{num * 2}
//    )

    //简写如下：
    val mapRDD = rdd.map(_* 2)
    mapRDD.collect().foreach(println)

    sc.stop()
  }

}
