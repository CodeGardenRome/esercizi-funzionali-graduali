module KataZero.KataZero (stepA,stepB,stepC,stepD)  where

import Data.Char
import Data.List

stepA :: [Int]
stepA = [1..3]

stepB :: [Int]
stepB = [n | n <- [1..10], mod n 2 == 0]

stepC :: [Int]
stepC = [n | n <- [1..100], mod n 7 == 0]

stepD :: [String] -> [String]
stepD uomini =  [u | u <- uomini, isPrefixOf "C" u]
