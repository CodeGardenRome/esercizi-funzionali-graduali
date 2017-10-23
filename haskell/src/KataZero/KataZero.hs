module KataZero.KataZero (
  stepA,stepB,stepC,stepD,stepE,
  stepF,stepG,stepH,stepI
)  where

import Data.Char
import Data.List
import System.Random

stepA :: [Int]
stepA = [1..3]

-- TODO Risolvere questi esercizi usando filter e non le list comprehension

stepB :: [Int]
stepB = [n | n <- [1..10], mod n 2 == 0]

stepC :: [Int]
stepC = [n | n <- [1..100], mod n 7 == 0]

stepD :: [String] -> [String]
stepD xs =  [u | u <- xs, isPrefixOf "C" u] -- Alternativa: filter (isPrefixOf "C") uomini

average :: [Int] -> Double
average xs = realToFrac (sum xs) / genericLength xs

stepE :: Double
stepE =  average [n | n <- [1..100], mod n 8 == 0]

stepF :: Int
stepF = sum [n | n <- [1..1000], mod n 6 == 0]

stepG :: [String] -> [String]
stepG xs = sort xs

atRandIndex :: [a] -> IO a  -- note that this is gives itself an IO action
atRandIndex l = do
    i <- randomRIO (0, length l - 1)
    return $ l !! i

stepH :: IO Int
stepH = atRandIndex [n | n <- [1..1000], mod n 41 == 0]

stepI :: [String] -> String
stepI xs = intercalate ", " xs
