package io.evilcorp.step01

import org.scalatest._

class Step01Spec extends WordSpec with Matchers {

	val input = "You are a nice person"
	val expected = "You are a XXXX person"

	"The imperative censorship function" should {
		"censor nice words" in {
			Step01ScalaImperative(input) shouldBe expected
		}
	}

	"The functional censorship function" should {
		"censor nice words" in {
			Step01ScalaFunctional(input) shouldBe expected
		}
	}

}