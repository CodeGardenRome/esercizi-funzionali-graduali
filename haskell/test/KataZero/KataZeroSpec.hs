module KataZero.KataZeroSpec (main, spec) where

import Test.Hspec
import KataZero.KataZero

-- `main` is here so that this module can be run from GHCi on its own.  It is
-- not needed for automatic spec discovery.
main :: IO ()
main = hspec spec

spec :: Spec
spec = do
  let uomini = ["Tizio", "Caio", "Sempronio", "Mevio", "Filano", "Calpurnio"]
  describe "KataZero" $ do
    it "stepA" $ do
      stepA `shouldBe` [1,2,3]
    it "stepB" $ do
      stepB `shouldBe` [2,4,6,8,10]
    it "stepC" $ do
      stepC `shouldBe` [7,14,21,28,35,42,49,56,63,70,77,84,91,98]
    it "stepD" $ do
      stepD uomini `shouldBe` ["Caio","Calpurnio"]
