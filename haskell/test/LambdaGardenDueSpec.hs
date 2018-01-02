module LambdaGardenDueSpec (main, spec) where

import Test.Hspec
import LambdaGardenDue

main :: IO ()
main = hspec spec

spec :: Spec
spec = do
  let matrice = [ [' ', 'O', 'X'], [' ', 'X', 'O'], ['X', ' ', ' '] ]
  describe "Esercizio1" $ do
    it "passoA" $ do
      shouldBe (vincitoreRiga ['X','X','X']) 'X'
      shouldBe (vincitoreRiga ['O','O','O']) 'O'
      shouldBe (vincitoreRiga ['O','O','X']) ' '
      shouldBe (vincitoreRiga ['O',' ','X']) ' '
    it "passoB" $ do
      shouldBe (cellaSuccessivaRighe (2,1) ) (2,2)
      shouldBe (cellaSuccessivaColonne (1,1) ) (2,1)
      shouldBe (cellaSuccessivaDiagonaleMaggiore (1,1)) (2,2)
      shouldBe ( cellaSuccessivaDiagonaleMinore (2,0)) (1,1)
    it "passoC" $ do
      shouldBe (generaVettore matrice (0,0) cellaSuccessivaRighe) [' ', 'O', 'X']
      shouldBe (generaVettore matrice (0,0) cellaSuccessivaColonne) [' ', ' ', 'X']
      shouldBe (generaVettore matrice (0,0) cellaSuccessivaDiagonaleMaggiore) [' ', 'X', ' ']
      shouldBe (generaVettore matrice (2,0) cellaSuccessivaDiagonaleMinore) ['X', 'X', 'X']
    it "passoD" $ do
      shouldBe (vincitoreMatrice matrice) 'X'
    --it "passoE" $ do
