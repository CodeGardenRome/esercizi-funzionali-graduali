import Test.Hspec

import qualified KataZero.KataZeroSpec

main :: IO ()
main = hspec spec

spec :: Spec
spec = do
  describe "KataZero" KataZero.KataZeroSpec.spec
