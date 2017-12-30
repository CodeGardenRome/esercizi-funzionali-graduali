module LambdaGardenDue(
  aggrega, vincitore,
  cellaSuccessivaRighe, cellaSuccessivaColonne, cellaSuccessivaDiagonaleMaggiore, cellaSuccessivaDiagonaleMinore,
  generaVettore, generaVettoriRiga
) where

import Data.List --Serve per transpose

aggrega :: Char -> Char -> Char
aggrega 'X' 'X' = 'X'
aggrega 'O' 'O' = 'O'
aggrega x y = ' '

vincitore :: [Char] -> Char
vincitore xs = if foldl aggrega 'X' xs == 'X'
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
trovaVincitoreRighe matrice = foldr aggregaVincitore ' '  (map vincitore matrice)

trovaVincitoreColonne :: [[Char]] -> Char
trovaVincitoreColonne matrice = foldr aggregaVincitore ' '  (map vincitore (transpose matrice))

generaVettoriRiga :: [[Char]] -> (Int,Int) -> [[Char]]
generaVettoriRiga matrice (x,y) =
  if x>=0 && y>=0 && (x < length matrice) && (y < length (matrice !! x))
    then generaVettore matrice (x,y) cellaSuccessivaRighe :
    generaVettoriRiga matrice (cellaSuccessivaColonne (x,y))
    else []

generaVettoriColonna :: [[Char]] -> (Int,Int) -> [[Char]]
generaVettoriColonna matrice (x,y) =
  if x>=0 && y>=0 && (x < length matrice) && (y < length (matrice !! x))
    then generaVettore matrice (x,y) cellaSuccessivaColonne :
    generaVettoriRiga matrice (cellaSuccessivaRighe (x,y))
    else []
