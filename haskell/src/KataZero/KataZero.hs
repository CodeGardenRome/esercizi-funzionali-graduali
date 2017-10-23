module KataZero.KataZero (
  stepA,stepB,stepC,stepD,stepE,
  stepF,stepG,stepH,stepI,stepJ,
  stepK,stepL,stepM
)  where

import Prelude as P
import Data.Char
import Data.List
import Data.Set as S
import Data.Map as M
import System.Random

stepA :: [Int]
stepA = [1..3]

stepB :: [Int]
stepB = [n | n <- [1..10], mod n 2 == 0]

stepC :: [Int]
stepC = [n | n <- [1..100], mod n 7 == 0]

stepD :: [String] -> [String]
stepD xs =  [u | u <- xs, isPrefixOf "C" u]
-- Alternativa: stepD xs = filter (isPrefixOf "C") xs

average :: [Int] -> Double
average xs = realToFrac (sum xs) / genericLength xs

stepE :: Double
stepE =  average [n | n <- [1..100], mod n 8 == 0]

stepF :: Int
stepF = sum [n | n <- [1..1000], mod n 6 == 0]

stepG :: [String] -> [String]
stepG xs = sort xs

-- Restituisce un elemento casuale da una lista
atRandIndex :: [a] -> IO a  -- note that this is gives itself an IO action
atRandIndex l = do
    i <- randomRIO (0, length l - 1)
    return $ l !! i

stepH :: IO Int
stepH = atRandIndex [n | n <- [1..1000], mod n 41 == 0]

stepI :: [String] -> String
stepI xs = intercalate ", " xs

stepJ :: [String] -> Set String
stepJ xs = S.fromList xs

stepK :: [String] -> Map Int String
stepK xs = M.fromList $ generateList xs

generateList :: [String] -> [(Int,String)]
generateList (x:xs) = (length(x), x) : generateList xs
generateList [] = []

stepL :: [String] -> [Int]
stepL xs = P.map length xs

stepM :: [String] -> [String]
stepM xs = P.map (take 1) xs
