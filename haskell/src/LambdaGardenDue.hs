module LambdaGardenDue(
  aggrega, vincitore

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
