package io.evilcorp.step01

object Step01ScalaFunctional {
  def apply(string : String) : String =
    string.split(" ")
      .map((s) => if (s.equals("nice")) "XXXX" else s)
      .mkString(" ")

  def main(args: Array[String]): Unit = {
    println(apply("You are a nice person"))
  }
}
