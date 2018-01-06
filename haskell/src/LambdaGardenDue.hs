module LambdaGardenDue(
  aggrega, vincitoreRiga,
  cellaSuccessivaRighe, cellaSuccessivaColonne, cellaSuccessivaDiagonaleMaggiore, cellaSuccessivaDiagonaleMinore,
  generaVettore, vincitoreMatrice
) where

import Data.List --Serve per transpose

aggrega :: Char -> Char -> Char
aggrega 'X' 'X' = 'X'
aggrega 'O' 'O' = 'O'
aggrega x y = ' '

vincitoreRiga :: [Char] -> Char
vincitoreRiga xs = if foldl aggrega 'X' xs == 'X'
  then 'X'
  else if foldl aggrega 'O' xs == 'O'
    then 'O'
    else ' '

cellaSuccessivaRighe :: (Int, Int) -> (Int, Int)
cellaSuccessivaRighe (x,y) = (x,y+1)

cellaSuccessivaColonne :: (Int, Int) -> (Int, Int)
cellaSuccessivaColonne (x,y) = (x+1,y)

cellaSuccessivaDiagonaleMaggiore :: (Int, Int) -> (Int, Int)
cellaSuccessivaDiagonaleMaggiore (x,y) = (x+1,y+1)

cellaSuccessivaDiagonaleMinore :: (Int, Int) -> (Int, Int)
cellaSuccessivaDiagonaleMinore (x,y) = (x-1,y+1)

generaVettore :: [[Char]] -> (Int,Int) -> ((Int, Int) -> (Int, Int)) -> [Char]
generaVettore matrice (x,y) funSuccessore =
  if x>=0 && y>=0 && (x < length matrice) && (y < length (matrice !! x))
    then (matrice !! x !! y) : (generaVettore matrice (funSuccessore (x,y)) funSuccessore)
    else []

aggregaVincitore :: Char -> Char -> Char
aggregaVincitore 'X' ' ' = 'X'
aggregaVincitore ' ' 'X' = 'X'
aggregaVincitore 'O' ' ' = 'O'
aggregaVincitore ' ' 'O' = 'O'
aggregaVincitore ' ' ' ' = ' '

trovaVincitoreRighe :: [[Char]] -> Char
trovaVincitoreRighe matrice = foldr aggregaVincitore ' '  (map vincitoreRiga matrice)

trovaVincitoreColonne :: [[Char]] -> Char
trovaVincitoreColonne matrice = foldr aggregaVincitore ' '  (map vincitoreRiga (transpose matrice))

vincitoreMatrice :: [[Char]] -> Char
vincitoreMatrice matrice = do
  let righe = trovaVincitoreRighe matrice
  let colonne = trovaVincitoreColonne matrice
  let diagonaleMaggiore = vincitoreRiga (generaVettore matrice (0,0) cellaSuccessivaDiagonaleMaggiore)
  let diagonaleMinore = vincitoreRiga (generaVettore matrice (2,0) cellaSuccessivaDiagonaleMinore)
  foldr aggregaVincitore ' ' [righe, colonne, diagonaleMaggiore,diagonaleMinore]
