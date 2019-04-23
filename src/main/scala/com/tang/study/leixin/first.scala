package com.tang.study.leixin

import scala.io.Source

object first {

  def main(args: Array[String]): Unit = {

    val x:Int = 10
    println(x.asInstanceOf[Double])
    lazy val a:Int = 10
    println(a)
    lazy val text = Source.fromFile("E:\\data\\rdd\\wordcount.txt")
    println(text.mkString)

    val str:String = "hello word,my name is tang.and I'm 34,454,454,341"
    val pattern = "[0-9]+".r
    val res = pattern.findAllMatchIn(str)
    for (ele <- res){
      println(ele)
    }
    def max(x:Int,y:Int):Int={
      if (x>y)
        x
      y
    }
  }
}

