package org.lambdaroma

object DataModel {

  type Matrix = Array[Array[String]]
  type Winner = Option[String]
  type Position = (Int, Int)

  val X = "X"
  val O = "O"
  val symbols = List(X, O)

  val test_matrix_3x3 =
    Array (
     Array ( " ", "O", "X"),
     Array ( " ", "X", "O"),
     Array ( "X", " ", " ")
    )

}

object Set_Operations {

  def properly_contains[A](s1: Set[A], s2: Set[A]): Boolean =
    (s1 & s2) == s2

}

object Esercizio_1 {

  import DataModel._

  val matrix_size = 3

  val all_positions = (
    for {
      x <- 0 until matrix_size
      y <- 0 until matrix_size
    } yield (x, y)
  ).toSet

  val (major_diagonal, inverse_diagonal) = (
    Array.tabulate(matrix_size)( i => (i, i) ).toSet,
    Array.tabulate(matrix_size)( i => (i, matrix_size - i - 1) ).toSet
  )

  def winner(matrix: Matrix): Winner = {
    val positions_for = read_positions(matrix) _
    val winners = symbols map (symbol =>
      symbol -> (positions_for andThen winning_positions_?)(symbol)
    )
    
    winners collectFirst {
      case (symbol, wins) if wins => symbol
    }
  }

  def read_positions(matrix: Matrix)(symbol: String): List[Position] =
    (all_positions filter {
      case (x, y) => matrix(x)(y) == symbol
    }).toList

  def winning_positions_?(positions: List[Position]): Boolean = {
    import Set_Operations._

    def counting(coords: List[Int]): List[Int] =
      coords.groupBy(identity)
      .values
      .toList
      .map(_.size)

    val (xs, ys) = positions.unzip
    
    //same row
    counting(xs).exists(_ == matrix_size) ||
    //same column
    counting(ys).exists(_ == matrix_size) ||
    //diagonals
    properly_contains(positions.toSet, major_diagonal) || 
    properly_contains(positions.toSet, inverse_diagonal)

  }

}