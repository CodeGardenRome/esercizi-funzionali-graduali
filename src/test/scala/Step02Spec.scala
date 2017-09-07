package io.evilcorp.step02

import org.scalatest._

class Step02Spec extends WordSpec with Matchers {

	val censored = Set("nice", "pony", "sun", "light", "fun", "happy", "funny", "joy")
	val input = "Such a nice day with a bright sun, makes me happy"
	val expected = "Such a XXXX day with a bright XXX, makes me XXXXX"

	"The imperative censorship function" should {
		"censor a list of provided words" in {
			new Step02ScalaImperative.Censor(censored)(input) shouldBe expected
		}
	}

	"The functional censorship function" should {
		"censor a list of provided words" in {
			Step02ScalaFunctional(censored)(input) shouldBe expected
		}
	}

}