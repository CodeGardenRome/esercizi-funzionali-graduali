package io.evilcorp.step03

import scala.collection.mutable.StringBuilder

object Step03ScalaImperative {

  class Censor(censored: Set[String]) {

    def apply(text: String): String = {
      val buffer = new StringBuilder(text)
      for (verboten <- censored; word <- buffer.split(' ')) {
        if (word.toLowerCase.startsWith(verboten.toLowerCase)) {
          val replacement = fillString('X', word.length)
          val from = buffer.indexOf(word)
          buffer.replace(from, from + word.length, replacement)
        }
      }
      buffer.toString
    }

}

  //This is for illustrative purpose
  //It's reasonable to expect this to be implemented the same way as Marked.apply
  def fillString(char: Char, size: Int): String = {
    var builder = new StringBuilder(size)
    var i = size
    while (i > 0) { 
      builder.append(char)
      i -= 1
    }
    return builder.toString
  }

}


object Step03ScalaFunctional {
  def apply(censored: Set[String])(text: String): String = {
    val applyCensorship: String => String = word =>
      if (censored.exists(verboten => word startsWith verboten))
        Marked(word)
      else
        word

    text.split(' ')
      .map(applyCensorship)
      .mkString(" ")
  }

}

object Marked {
  private val marker = 'X'
  //could be memoized
  def apply(word: String): String = Array.fill(word.size)(marker).mkString
}