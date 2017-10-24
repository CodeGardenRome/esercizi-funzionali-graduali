module Katas.KataZero (
  stepA,stepB,stepB2,stepB3,stepC,stepC2,
  stepD,stepD2,stepE,stepE2,
  stepF,stepF2,stepF3,stepG,stepH,stepH2,
  stepI,stepJ,
  stepK,stepL,stepL2,stepM,stepM2
)  where

import Prelude as P
import Data.Char
import Data.List
import Data.Set as S
import Data.Map as M
import System.Random

-- Tecnica del list comprehension
stepA :: [Int]
stepA = [1..3]

-- Di nuovo list comprehension
stepB :: [Int]
stepB = [n | n <- [1..10], mod n 2 == 0]

-- Qui usiamo la funzione filter (presa da Prelude) con una lambda
stepB2 :: [Int]
stepB2 = P.filter (\n -> mod n 2 == 0) [1..10]

-- Qui viene usata la ricorsione ed il pattern matching
lasciaSoloPari :: [Int] -> [Int]
lasciaSoloPari (x:xs) =
  if mod x 2 == 0 then x:lasciaSoloPari xs else lasciaSoloPari xs
lasciaSoloPari [] = []

stepB3 :: [Int]
stepB3 = lasciaSoloPari [1..10]

-- List comprehension
stepC :: [Int]
stepC = [n | n <- [1..100], mod n 7 == 0]

-- Funzione filter presa da Prelude
stepC2 :: [Int]
stepC2 = P.filter (\n -> mod n 7 == 0) [1..100]

-- List comprehension
stepD :: [String] -> [String]
stepD xs =  [u | u <- xs, isPrefixOf "C" u]

-- Funzione filter presa da Prelude
stepD2 :: [String] -> [String]
stepD2 xs = P.filter (isPrefixOf "C") xs

-- Dobbiamo convertire gli interi in Double prima di dividere
average :: [Int] -> Double
average xs = realToFrac (sum xs) / genericLength xs

stepE :: Double
stepE =  average [n | n <- [1..100], mod n 8 == 0]

-- Uso della ricorsione assieme al pattern matching
calculateAverage :: Int -> Int -> [Int] -> Double
calculateAverage sum count (x:xs) = calculateAverage (sum+x) (count+1) xs
calculateAverage sum count [] = (fromIntegral sum) / (fromIntegral count)

stepE2 :: Double
stepE2 = calculateAverage 0 0 [n | n <- [1..100], mod n 8 == 0]

-- List comprehension
stepF :: Int
stepF = sum [n | n <- [1..1000], mod n 6 == 0]

-- Funzione filter presa da Prelude
stepF2 :: Int
stepF2 = sum $ P.filter (\n -> mod n 6 == 0) [1..1000]

-- Ricorsione e pattern matching
sommaMultipliDiSei :: [Int] -> Int
sommaMultipliDiSei (x:xs) =
  if mod x 6 == 0
    then x + sommaMultipliDiSei xs
    else sommaMultipliDiSei xs
sommaMultipliDiSei [] = 0

stepF3 :: Int
stepF3 = sommaMultipliDiSei [1..1000]

stepG :: [String] -> [String]
stepG xs = sort xs

-- Restituisce un elemento casuale da una lista
atRandIndex :: [a] -> IO a
atRandIndex l = do
    i <- randomRIO (0, length l - 1)
    return $ l !! i

stepH :: IO Int
stepH = atRandIndex [n | n <- [1..1000], mod n 41 == 0]

stepH2 :: IO Int
stepH2 = atRandIndex $ P.filter (\n -> mod n 41 == 0) [1..1000]

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

stepL2 :: [String] -> [Int]
stepL2 (x:xs) = length x : stepL2 xs
stepL2 [] = []

stepM :: [String] -> [String]
stepM xs = P.map (take 1) xs

stepM2 :: [String] -> [String]
stepM2 (x:xs) = (take 1 x) : stepM2 xs
stepM2 [] = []
