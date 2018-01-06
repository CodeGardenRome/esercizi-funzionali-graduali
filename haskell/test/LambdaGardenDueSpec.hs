module LambdaGardenDueSpec (main, spec) where

import Test.Hspec
import LambdaGardenDue

main :: IO ()
main = hspec spec

spec :: Spec
spec = do
  let matriceA = [ [' ', 'O', 'X'], [' ', 'X', 'O'], ['X', ' ', ' '] ]
  let matriceB = [ [' ', ' ', ' '], [' ', ' ', ' '], [' ', ' ', ' '] ]
  let matriceC = [ [' ', 'X', 'O'], [' ', 'O', 'X'], ['O', ' ', ' '] ]
  let matriceD = [ ['O', 'O', ' '], ['X', 'X', 'X'], [' ', ' ', ' '] ]
  let matrice10x10 = [ ['X',' ',' ',' ',' ',' ',' ',' ','O',' '], [' ','X',' ',' ',' ',' ',' ',' ','O',' '], [' ',' ','X',' ',' ',' ',' ',' ','O',' '],[' ',' ',' ','X',' ',' ',' ',' ','O',' '], [' ',' ',' ',' ','X',' ',' ',' ','O',' '],  [' ',' ',' ',' ',' ','X',' ',' ','O',' '],  [' ',' ',' ',' ',' ',' ','X',' ','O',' '],  [' ',' ',' ',' ',' ',' ',' ','X','O',' '],  [' ',' ',' ',' ',' ',' ',' ',' ','X','O'],  [' ',' ',' ',' ',' ',' ',' ',' ','O','X']  ]
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
      shouldBe (generaVettore matriceA (0,0) cellaSuccessivaRighe) [' ', 'O', 'X']
      shouldBe (generaVettore matriceA (0,0) cellaSuccessivaColonne) [' ', ' ', 'X']
      shouldBe (generaVettore matriceA (0,0) cellaSuccessivaDiagonaleMaggiore) [' ', 'X', ' ']
      shouldBe (generaVettore matriceA (2,0) cellaSuccessivaDiagonaleMinore) ['X', 'X', 'X']
    it "passoD" $ do
      shouldBe (vincitoreMatrice matriceA) 'X'
      shouldBe (vincitoreMatrice matriceB) ' '
      shouldBe (vincitoreMatrice matriceC) 'O'
      shouldBe (vincitoreMatrice matriceD) 'X'
  describe "Esercizio1" $ do
    it "passoE" $ do
      shouldBe (vincitoreMatrice matrice10x10) 'X'
