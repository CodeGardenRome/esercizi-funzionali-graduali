module Katas.KataZeroSpec (main, spec) where

import Test.Hspec
import Data.Set as S
import Data.Map as M
import Katas.KataZero

-- `main` is here so that this module can be run from GHCi on its own.  It is
-- not needed for automatic spec discovery.
main :: IO ()
main = hspec spec

spec :: Spec
spec = do
  let uomini = ["Tizio", "Caio", "Sempronio", "Mevio", "Filano", "Calpurnio"]
  let donne = ["Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara"]
  describe "KataZero" $ do
    it "stepA" $ do
      stepA `shouldBe` [1,2,3]
    it "stepB" $ do
      stepB `shouldBe` [2,4,6,8,10]
    it "stepB2" $ do
      stepB2 `shouldBe` [2,4,6,8,10]
    it "stepB3" $ do
      stepB3 `shouldBe` [2,4,6,8,10]
    it "stepC" $ do
      stepC `shouldBe` [7,14,21,28,35,42,49,56,63,70,77,84,91,98]
    it "stepC2" $ do
      stepC2 `shouldBe` [7,14,21,28,35,42,49,56,63,70,77,84,91,98]
    it "stepD" $ do
      stepD uomini `shouldBe` ["Caio","Calpurnio"]
    it "stepD2" $ do
      stepD2 uomini `shouldBe` ["Caio","Calpurnio"]
    it "stepE" $ do
      shouldBe stepE 52
    it "stepE2" $ do
      shouldBe stepE2 52
    it "stepF" $ do
      shouldBe stepF 83166
    it "stepF2" $ do
      shouldBe stepF2 83166
    it "stepF3" $ do
      shouldBe stepF3 83166
    it "stepG" $ do
      shouldBe (stepG uomini) ["Caio","Calpurnio","Filano","Mevio","Sempronio","Tizio"]
    it "stepH" $ do
      r <- stepH
      shouldSatisfy r (\n -> mod n 41 == 0)
    it "stepH2" $ do
      r <- stepH2
      shouldSatisfy r (\n -> mod n 41 == 0)
    it "stepI" $ do
      shouldBe (stepI uomini) "Tizio, Caio, Sempronio, Mevio, Filano, Calpurnio"
    it "stepJ" $ do
      shouldBe (stepJ uomini) (S.fromList uomini)
    it "stepK" $ do
      shouldBe (stepK donne) (M.fromList [(4,"Anna"),(5,"Carla"),(6,"Angela"),(6,"Chiara"),(4,"Emma"),(5,"Maria"),(4,"Sara")])
    it "stepL" $ do
      shouldBe (stepL donne) [4,5,6,6,4,5,4]
    it "stepL2" $ do
      shouldBe (stepL2 donne) [4,5,6,6,4,5,4]
    it "stepM" $ do
      shouldBe (stepM donne) ["A","C","A","C","E","M","S"]
    it "stepM2" $ do
      shouldBe (stepM2 donne) ["A","C","A","C","E","M","S"]
