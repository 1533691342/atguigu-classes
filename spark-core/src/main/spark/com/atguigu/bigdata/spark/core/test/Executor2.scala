package com.atguigu.bigdata.spark.core.test

import java.io.{InputStream, ObjectInputStream}
import java.net.{ServerSocket, Socket}

object Executor2 {
  def main(args: Array[String]): Unit = {
    //启动服务器，接受数据
    val server = new ServerSocket(8888)
    println("服务器【8888】启动，等待接收数据")

    //等待客户端连接
    val client:Socket = server.accept()

    //输入流：接收消息
    val in: InputStream = client.getInputStream

    //读取对象
    val ObjIn = new ObjectInputStream(in)

    val task :SubTask = ObjIn.readObject().asInstanceOf[SubTask]
    val ints:List[Int] = task.compute()
    println("计算节点【8888】计算结果为:  " + ints)
    ObjIn.close()
    client.close()
    server.close()



  }
}
