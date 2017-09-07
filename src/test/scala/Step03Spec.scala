package io.evilcorp.step03

import org.scalatest._

class Step03Spec extends WordSpec with Matchers {

  val censored = Set("friend", "nice", "pony", "sun", "light", "fun", "happy", "funny", "joy")
  val input = "You are so friendly!"
  val expected = "You are so XXXXXXXXX"

  "The imperative censorship function" should {
    "censor words with a prefix" in {
      new Step03ScalaImperative.Censor(censored)(input) shouldBe expected
    }
  }

  "The functional censorship function" should {
    "censor words with a prefix" in {
      Step03ScalaFunctional(censored)(input) shouldBe expected
    }
  }

}