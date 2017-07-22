package io.evilcorp.step02

import org.scalatest._

class Step02Spec extends WordSpec with Matchers {

	import io.vavr.collection.HashSet

	val censored = Set("nice", "pony", "sun", "light", "fun", "happy", "funny", "joy")
	val javaslangCensored = HashSet.of("nice", "pony", "sun", "light", "fun", "happy", "funny", "joy")
	val input = "Such a nice day with a bright sun, makes me happy"
	val expected = "Such a XXXX day with a bright XXX, makes me XXXXX"

	"The imperative censorship function" should {
		"censor a list of provided words" in {
			Step02ScalaImperative(censored)(input) shouldBe expected
		}
	}

	"The functional censorship function" should {
		"censor a list of provided words" in {
			Step02ScalaFunctional(censored)(input) shouldBe expected
		}
	}

	"The javaslang censorship function" should {
		"censor a list of provided words" in {
			new Step02Vavr()(javaslangCensored, input) shouldBe expected
		}
	}

}