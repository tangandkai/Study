package com.tang.study.leixin

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class test {

  def apply: test = new test()
  protected var name = "tang"
  var xx:String = _
}
object test{
  def apply: test = new test()
}
object Main{
  var yy:String = _

  implicit class calculate(x:Int){
    def add(y:Int):Int ={
      x+y
    }
  }
  ArrayBuffer()
  def main(args: Array[String]): Unit = {
//    val instance = new test
//    instance.xx = "tang"
//    print(instance.xx)
//    val l =  List(1,2,3,4)
//    val a = l.to[ListBuffer]
//    println(a.mkString(","))
//    val te = "tang"
//    println(s"hello,$te")
//    val s = {(x1:Int,x2:Int)=>{x1+x2}}
//    val list = List(List(1,2),List(2,3),List(3,4))
//    list.map(x=>x.map(_*2))
//    list.flatMap(x=>x.map(_*2))

//    implicit val name = "kai"
//    def testp(implicit name:String):Unit={
//      println(name+"~~~~~~~~~~~~~~~~~~~~~~")
//    }
//
//    testp("tang")
//    testp


//    implicit def changeMan(man:Man):SuperMan = new SuperMan(man.name)
//    val man = new Man("tang")
//    man.eat()
//    man.fly()

    println(1.add(9))

  }
}

class Man(var name:String){
  def eat(): Unit ={
    println(s"the common man [$name] eat......")
  }
}

class SuperMan(var name:String){

  def fly(): Unit ={
    println(s"the superman [$name] fly.....")
  }
}
