package io.evilcorp.step01

import scala.collection.mutable.StringBuilder

object Step01ScalaImperative {
  def apply(string : String) : String = {
    val words = string.split(" ")
	val builder = new StringBuilder
	for(s <- words) {
	  if(s == "nice")
	    builder.append("XXXX ")
	  else
	  	builder.append(s).append(" ")
	}
	if (builder.nonEmpty) builder.deleteCharAt(builder.size - 1)
	builder.toString
  }
}

object Step01ScalaFunctional {
  def apply(string : String) : String =
    string.split(" ")
	  .map(word => if (word == "nice") "XXXX" else word)
	  .mkString(" ")

}
