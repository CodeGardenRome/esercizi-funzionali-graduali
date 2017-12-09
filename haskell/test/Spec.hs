import Test.Hspec

import qualified Katas.KataZeroSpec
import qualified LambdaGardenDueSpec

main :: IO ()
main = hspec spec

spec :: Spec
spec = do
  describe "KataZero" Katas.KataZeroSpec.spec
  describe "LambdaGardenDue" LambdaGardenDueSpec.spec
