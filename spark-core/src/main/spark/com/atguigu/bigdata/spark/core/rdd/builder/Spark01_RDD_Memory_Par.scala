package com.atguigu.bigdata.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Memory_Par {
  def main(args: Array[String]): Unit = {
    val  sparkConf=new SparkConf().setMaster("local[*]").setAppName("RDD")
    sparkConf.set("spark.default.parallelism","5") //分区为5
    val sc = new SparkContext(sparkConf)

    // RDD 的并行度 & 分区
    // makeRDD 方法可以传递第二个参数，这个参数表示分区的数量
    // 第二个参数可以不传递，那么 makeRDD 方法会使用
    // 默认值：defaultParallelism(默认并行度)
    // 默认并行度：scheduler.conf.getIn("spark.default.parallelism","totalCores")
    // spark 在默认情况下，从配置对象中获取配置参数：spark.default.parallelism
    // 如果获取不到，那么使用 totalCores 属性，这个属性取值为当前运行环境的最大可用核数
    //val rdd = sc.makeRDD(List(1, 2, 3, 4), 2) 表示 2个分区
    //val rdd = sc.makeRDD(List(1, 2, 3, 4)) 分区与本地运行环境的最大可用核数一直
    val rdd = sc.makeRDD(List(1, 2, 3, 4))

    // 将处理的数据保存成 分区文件
    rdd.saveAsTextFile("output")

    sc.stop()
  }

}
