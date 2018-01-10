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

/** Esercizio 1
  *
  * Data una matrice 3x3 che rappresenta una partita a filetto conclusa, 
  * scrivere una funzione vincitorePrimoTentativo che determina se:
  * * ha vinto "X", 
  * * ha vinto "O" 
  * * o c'è stato il pareggio " ".
  * 
  * Ad esempio, data la matrice: 
  * 
  * [ [" ", "O", "X"],
  *   [" ", "X", "O"],
  *   ["X", " ", " "] ]
  * 
  * La funzione deve restituire l'esito corrispondente alla vittoria di "X".
  * 
  */
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

/** Esercizio 2
  * 
  * Scrivere una funzione vincitore che, dato un vettore di 3 elementi, restitusce:
  * * "X" se contiene tutte "X"
  * * "O" se contiene tutte "O"
  * * " " altrimenti
  * 
  * Ad esempio:
  * * vincitore(["X","X","X"]) deve restituire "X"
  * * vincitore(["O","O","O"]) deve restituire "O"
  * * vincitore(["O","O","X"]) deve restituire " "
  * * vincitore(["O"," ","X"]) deve restituire " "
  * 
  * È possibile svolgere questo esercizio usando la funzione filter, con altre?
  */
object Esercizio_2 extends Data_Model {

  def winner(row: Row): Winner =
    symbols find ( symbol =>
      row forall (_ == symbol)
    )

}


/** Esercizio 3
  * 
  * Scrivere delle funzioni che, data una cella di partenza, restituiscono la cella
  * successiva, per coprire una riga una colonna o una diagonale.
  * 
  * Ad esempio, la funzione
  * * cellaSuccessivaRighe([0,0]) = [1,0]
  * * cellaSuccessivaColonne([0,0]) = [0,1]
  * * cellaSuccessivaDiagonaleMaggiore([0,0]) = [1,1]
  * * cellaSuccessivaDiagonaleMinore([0,2]) = [1,1]
  * 
  * Queste funzioni sono dette funzioni successore.
  * 
  */
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


/** Esercizio 4
  * 
  * Scrivere una funzione generaVettore che prende in ingresso:
  * * la matrice 3x3
  * * la cella di partenza
  * * la funzione successore
  * 
  * E restituisce un vettore di 3 elementi corrispondente alla riga.
  * 
  * Ad esempio, data la matrice: 
  * 
  * [ [" ", "O", "X"],
  *   [" ", "X", "O"],
  *   ["X", " ", " "] ]
  * 
  * Se la cella di partenza è [1,0] e la funzione successore è quella delle righe,
  * la funzione generaVettore dovrà restituire il vettore:
  * 
  * [" ","X","O"]
  * 
  * Se, invece, la cella di partenza è [0,2] e la funzione successore è quella delle colonne,
  * la funzione generaVettore dovrà restituire il vettore:
  * 
  * ["X","O"," "]
  * 
  */
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

/** Esercizio 5
  * 
  * Usa le funzioni create nell'esercizio precedente.
  * Data una matrice 3x3, restituire i vettori:
  * * delle righe, 
  * * delle colonne,
  * * delle diagonali
  * 
  * Ad esempio, data la matrice: 
  * 
  * [ [" ", "O", "X"],
  *   [" ", "X", "O"],
  *   ["X", " ", " "] ]
  * 
  * I vettori delle righe sono: 
  * * [" ", "O", "X"]
  * * [" ", "X", "O"]
  * * ["X", " ", " "]
  * 
  * I vettori delle colonne sono:
  * * [" "," ","X"]
  * * ["O","X"," "]
  * * ["X","O"," "]
  * 
  * I vettori delle diagonali sono:
  * * [" ","X"," "]
  * * ["X","X","X"]
  * 
  */
object Esercizio_5 extends Data_Model {

  import Esercizio_3._
  import Esercizio_4._

  def rows_of(matrix: Matrix): Vector[Row] = {
    val seed = Vector((0,0), (1,0), (2,0))
    seed map (generate_vector(matrix, _, successive_column))
  }

  def columns_of(matrix: Matrix): Vector[Row] = {
    val seed = Vector((0,0), (0,1), (0,2))
    seed map (generate_vector(matrix, _, successive_row))
  }

  def main_diagonal_of(matrix: Matrix): Row =
    generate_vector(matrix, (0,0), successive_main_diagonal)

  def inverse_diagonal_of(matrix: Matrix): Row =
    generate_vector(matrix, (2,2), successive_inverse_diagonal)

}