module LambdaGardenDueSpec (main, spec) where

import Test.Hspec
import LambdaGardenDue

main :: IO ()
main = hspec spec

spec :: Spec
spec = do
  describe "Esercizio1" $ do
    it "passoA" $ do
      vincitore ['X','X','X'] `shouldBe` 'X'
      vincitore ['O','O','O'] `shouldBe` 'O'
      vincitore ['O','O','X'] `shouldBe` ' '
      vincitore ['O',' ','X'] `shouldBe` ' '
