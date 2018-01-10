package org.lambdaroma

trait Data_Model {

  type Row = Vector[String]
  type Matrix = Vector[Row]
  type Winner = Option[String]
  type Position = (Int, Int)

  val X = "X"
  val O = "O"
  val symbols = List(X, O)
}

object Test_Matrix {
  
  val x_winner =
    Vector(
      Vector(" ", "O", "X"),
      Vector(" ", "X", "O"),
      Vector("X", " ", " ")
    )

  val o_winner =
    Vector(
      Vector("X", " ", "O"),
      Vector(" ", "X", "O"),
      Vector("X", " ", "O")
    )

  val stalemate =
    Vector(
      Vector("X", "O", "X"),
      Vector("O", "X", "O"),
      Vector("O", "X", "O")
    )

}



object Set_Operations {

  implicit class Powerset[A](s: Set[A]) {
    def superset_of(that: Set[A]): Boolean = superset_?(s, that)
  }

  def superset_?[A](s1: Set[A], s2: Set[A]): Boolean =
    (s1 & s2) == s2

}

object Esercizio_1 extends Data_Model {

  val matrix_size = 3

  val all_positions = (
    for {
      x <- 0 until matrix_size
      y <- 0 until matrix_size
    } yield (x, y)
  ).toSet

  val (main_diagonal, inverse_diagonal) = (
    Vector.tabulate(matrix_size)( i => (i, i) ).toSet,
    Vector.tabulate(matrix_size)( i => (i, matrix_size - i - 1) ).toSet
  )

  def winner(matrix: Matrix): Winner = {
    val positions_for = read_positions(matrix) _
    val winners = symbols map (symbol =>
      symbol -> (positions_for andThen winning_positions_?)(symbol)
    )
    
    winners collectFirst {
      case (symbol, true) => symbol
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
    val poset = positions.toSet
    
    //same row
    counting(xs).exists(_ == matrix_size) ||
    //same column
    counting(ys).exists(_ == matrix_size) ||
    //diagonals
    (poset superset_of main_diagonal) || 
    (poset superset_of inverse_diagonal)

  }

}

object Esercizio_2 extends Data_Model {

  def winner(row: Row): Winner =
    symbols find ( symbol =>
      row forall (_ == symbol)
    )

}

object Esercizio_3 extends Data_Model {

  def successive_row(p: Position): Position = p match {
    case (x, y) => (x + 1, y) 
  }

  def successive_column(p: Position): Position = p match {
    case (x, y) => (x, y + 1) 
  }

  def successive_main_diagonal(p: Position): Position = p match {
    case (x, y) => (x + 1, y + 1) 
  }

  def successive_inverse_diagonal(p: Position): Position = p match {
    case (x, y) => (x + 1, y - 1) 
  }

}

object Esercizio_4 extends Data_Model {

  def generate_vector(
    matrix: Matrix,
    start: Position,
    successor: Position => Position
  ): Row =
    Vector.iterate(start, matrix.size)(successor)
      .map {
        case (x,y) => matrix(x)(y)
      }


}