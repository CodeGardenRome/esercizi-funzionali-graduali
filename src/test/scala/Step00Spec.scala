package io.evilcorp.step00

import org.scalatest._

class Step00Spec extends WordSpec with Matchers {

  val men = Array("Tizio", "Caio", "Sempronio", "Mevio", "Filano", "Calpurnio")
  val women = Array("Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara")

  "The solution" when {

    "using the imperative approach" should {

      "produce 1, 2, 3" in {

        Step00ScalaImperative.a() should contain theSameElementsAs Array(1, 2, 3)

      }

      "produce all even numbers between 1 and 10" in {

        Step00ScalaImperative.b() should contain theSameElementsAs Array(2, 4, 6, 8, 10)

      }

      "produce all multiples of 7 in the range [1, 100]" in {

        Step00ScalaImperative.c() should contain theSameElementsAs 
          Array(7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 98)

      }

      "from the array of men find those starting with 'C'" in {

        Step00ScalaImperative.d(men) should contain theSameElementsAs Array("Caio", "Calpurnio")

      }

      "compute the average of multiples of 8 in the range [1, 100]" in {

        Step00ScalaImperative.e() shouldBe 52.0
        
      }

      "compute the sum of multiples of 6 in the range [1, 100]" in {

        Step00ScalaImperative.f() shouldBe 816

      }

      "return the sorted list of men" in {

        val toSort = Array.ofDim[String](men.size)
        men.copyToArray(toSort)

        val sortedMen = Step00ScalaImperative.g(toSort)

        sortedMen should contain theSameElementsAs men

        sortedMen should be (sorted)

      }

      "find any number in the range [1, 1000] that can be divided by 41 and print it" in {

        //how hard can it be to test your console output?
        import java.io.ByteArrayOutputStream

        var outStream: ByteArrayOutputStream = null

        val divisor = 41

        val printed = try {          
          outStream = new ByteArrayOutputStream

          Console.withOut(outStream) {
            Step00ScalaImperative.h(divisor)
          }

          outStream.toString

        } finally {
          if (outStream != null) outStream.close
        }

        printed should fullyMatch regex ("""\d+""".r)

        val number = printed.toInt

        number should be > 0

        number should be <= 1000

        (number / divisor.toDouble).isWhole shouldBe true

      }

      "produce a string containing the list of men, comma separated" in {

        Step00ScalaImperative.i(men) shouldBe "Tizio, Caio, Sempronio, Mevio, Filano, Calpurnio"

      }

      "produce a set from the array of men" in {

        Step00ScalaImperative.j(men) shouldBe Set("Tizio", "Caio", "Sempronio", "Mevio", "Filano", "Calpurnio")

      }

      "group women's names by length" in {

        val res = Step00ScalaImperative.k(women)
        res should have size 3
 
        res.get(4) shouldBe 'defined
        res.get(5) shouldBe 'defined
        res.get(6) shouldBe 'defined

        res.get(4).get should contain only ("Anna", "Emma", "Sara")
        res.get(5).get should contain only ("Carla", "Maria")
        res.get(6).get should contain only ("Angela", "Chiara")

      }

      "print women's names length" in {

        Step00ScalaImperative.l(women) shouldBe Array(4, 5, 6, 6, 4, 5, 4)

      }

      "print women's first letter" in {

        Step00ScalaImperative.m(women) shouldBe Array('A', 'C', 'A', 'C', 'E', 'M', 'S')

      }

    }

    "using the functional approach" should {

      "produce 1, 2, 3" in {

      }

      "produce all even numbers between 1 and 10" in {

      }

      "produce all multiples of 7 in the range [1, 100]" in {

      }

      "from the array of men find those starting with 'C'" in {

      }

      "compute the average of multiples of 8 in the range [1, 100]" in {
        
      }

      "compute the sum of multiples of 6 in the range [1, 100]" in {

      }

      "return the sorted list of men" in {

      }

      "find any number in the range [1, 100] that is dvided by 41 and print it" in {

      }

      "produce a string containing the list of men, comma separated" in {

      }

      "produce a set from the array of men" in {

      }

      "group women's names by length" in {

      }

      "print women's names length" in {
        
      }

      "print women's first letter" in {

      }



    }

  }

}
