module LambdaGardenDue(
  aggrega, vincitore,
  cellaSuccessivaRighe, cellaSuccessivaColonne, cellaSuccessivaDiagonaleMaggiore, cellaSuccessivaDiagonaleMinore,
  generaVettore
) where

aggrega :: Char -> Char -> Char
aggrega 'X' 'X' = 'X'
aggrega 'O' 'O' = 'O'
aggrega x y = ' '

prova = foldl aggrega ' ' ['X','X','X']

vincitore xs = if foldl aggrega 'X' xs == 'X'
  then 'X'
  else if foldl aggrega 'O' xs == 'O'
    then 'O'
    else ' '

cellaSuccessivaRighe :: (Int, Int) -> (Int, Int)
cellaSuccessivaRighe (x,y) = (x+1,y)

cellaSuccessivaColonne :: (Int, Int) -> (Int, Int)
cellaSuccessivaColonne (x,y) = (x,y+1)

cellaSuccessivaDiagonaleMaggiore :: (Int, Int) -> (Int, Int)
cellaSuccessivaDiagonaleMaggiore (x,y) = (x+1,y+1)

cellaSuccessivaDiagonaleMinore :: (Int, Int) -> (Int, Int)
cellaSuccessivaDiagonaleMinore (x,y) = (x-1,y+1)

generaVettore :: [[Int]] -> (Int,Int) -> ((Int, Int) -> (Int, Int)) -> [Int]
generaVettore matrice (x,y) funSuccessore =
  if (x <= length matrice) && (y <= length (matrice !! x))
    then (matrice !! x !! y) : (generaVettore matrice (funSuccessore (x,y)) funSuccessore)
    else []
