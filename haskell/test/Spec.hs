import Test.Hspec

import qualified Katas.KataZeroSpec

main :: IO ()
main = hspec spec

spec :: Spec
spec = do
  describe "KataZero" Katas.KataZeroSpec.spec
