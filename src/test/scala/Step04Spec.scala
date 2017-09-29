package io.evilcorp.step04

import org.scalatest._

class Step04Spec extends WordSpec with Matchers {

  val word_monger = Map(
    "bad" -> "ungood",
    "better" -> "gooder",
    "objection" -> "thoughtcrime",
    "agree" -> "crimestop"
  )

  val input = "Objection is bad, a better thing to do, is to agree."
  val expected = "Thoughtcrime is ungood, a gooder thing to do, is to crimestop."

  "The step four" should {

    "substitute critical words with corresponding others" in {
      Step04_scala_functional(word_monger)(input) shouldBe expected
    }

  }

}