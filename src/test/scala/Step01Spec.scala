package io.evilcorp.step01

import lambdaroma.step01.{Step01Imperative, Step01StreamsExplicit, Step01StreamsImplicit, Step01Vavr}
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

	"The java imperative censorship function" should {
		"censor nice words" in {
			new Step01Imperative()(input) shouldBe expected
		}
	}

	"The java stream censorship functions" should {
		"censor nice words" in {
			new Step01StreamsExplicit()(input) shouldBe expected
			new Step01StreamsImplicit()(input) shouldBe expected
		}
	}

	"The javaslang censorship function" should {
		"censor nice words" in {
			new Step01Vavr()(input) shouldBe expected
		}
	}

}