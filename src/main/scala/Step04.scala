package io.evilcorp.step04

object Step04_scala_functional {

  val unchanged = PartialFunction(identity[String])

  def apply(censored: Map[String, String])(sentence: String): String = {
    val tweak_if_needed = censored orElse unchanged
    splitted(sentence)
      .map(tweak_single(tweak_if_needed))
      .mkString
  }

  def tweak_single(censored: String => String)(word: String) = {
    val substitute = censored(word.toLowerCase)
    if (Title_casing.check(word))
      Title_casing(substitute) 
    else
      substitute
  }

  def splitted(sentence: String): Vector[String] =
    if (sentence.isEmpty)
      Vector.empty
    else {
      val (all_parsed, last) = 
        sentence.drop(1).foldLeft((Vector.empty[String], sentence.take(1))) {
          case ((parsed, current), letter) if current.head.isLetter == letter.isLetter =>
            (parsed, current + letter)
          case ((parsed, current), letter) =>
            (parsed :+ current, letter.toString) 
        }
      all_parsed :+ last
    }


}

sealed trait Casing {
  def check(word: String): Boolean
  def apply(word: String): String
}
object Lower_casing extends Casing {
  def check(word: String) =
    word.forall(_.isLower)
  
  def apply(word: String) =
    word.toLowerCase
}
object Upper_casing extends Casing {
  def check(word: String) =
    word.forall(_.isUpper)
  
  def apply(word: String) =
    word.toUpperCase
}
object Title_casing extends Casing {
  def check(word: String) =
    word.headOption match {
      case None => false
      case Some(letter) => letter.isUpper
    }
  
  def apply(word: String) =
    word match {
      case non_empty if non_empty.nonEmpty && non_empty.head.isLower => 
        non_empty.head.toUpper + non_empty.drop(1)
      case _ =>
        word
    }
}
