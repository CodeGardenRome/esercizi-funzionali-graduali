
package io.evilcorp.step00

object Step00ScalaImperative {

  import scala.collection.mutable.MutableList
  import scala.reflect.ClassTag

  def a() = multiplesOf(1, 3)

  def b() = multiplesOf(2, 10)

  def c() = multiplesOf(7, 100)

  def d(names: Array[String]) = keep(names, firstLetterIs('C'))

  def e() = average(multiplesOf(8, 100))

  def f() = sum(multiplesOf(6, 100))

  def g(names: Array[String]) = {
    scala.util.Sorting.quickSort(names)
    names
  }

  def h(divisor: Int) = {
    var i = 1
    var break = false

    while(!break && i <= 1000) {
      if (i % divisor == 0) {
        print(i)
        break = true
      }
      i += 1
    }
  }

  def i(names: Array[String]) = {
    val builder = new StringBuilder
    for (n <- names) {
      builder.append(n).append(", ")
    }
    builder.toString.dropRight(2)
  }

  def j(names: Array[String]) = {
    val set = scala.collection.mutable.Set.empty[String]
    for (name <- names) {
      set.add(name)
    }
    set
  }

  def k(names: Array[String]) = {
    val map = scala.collection.mutable.Map.empty[Int, Array[String]]
    for (name <- names) {
      accrueExisting(map, name.length, name)
    }
    map
  }

  def l(names: Array[String]) = {
    val lengths = Array.ofDim[Int](names.size)
    for (i <- 0 until names.size) {
      lengths(i) = names(i).length
    }
    lengths
  }

  def m(names: Array[String]) = {
    val initials = Array.ofDim[Char](names.size)
    for (i <- 0 until names.size) {
      initials(i) = names(i).charAt(0)
    }
    initials
  }

  def firstLetterIs(letter: Char): String => Boolean = text => text.startsWith(letter.toString)

  def multiplesOf(num: Int, bound: Int) = {
    val multiples = MutableList[Int]()
    for (i <- 1 to bound) {
      if (i % num == 0) multiples += i
    }
    multiples.toArray
  }

  def keep(values: Array[String], predicate: String => Boolean): Array[String] = {
    val filtered = MutableList[String]()
    for (v <- values) {
      if (predicate(v)) filtered += v
    }
    filtered.toArray
  }

  def average(values: Array[Int]): Double = {
    sum(values) / values.size
  }

  def sum(values: Array[Int]): Int = {
    var total = 0
    for (v <- values) total += v
    total
  }

  def accrueExisting[K, V : ClassTag](map: scala.collection.mutable.Map[K, Array[V]], key: K, value: V) = {
      val option = map.get(key)
      val values = option.getOrElse(Array.empty[V])
      val updates = values :+ value
      map.put(key, updates)
  }

}