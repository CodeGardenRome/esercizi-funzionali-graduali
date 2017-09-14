name := "incremental-katas-jvm-langs"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.3"

val scalazVersion = "7.2.15"


libraryDependencies ++= Seq(
	"org.scalaz"    %% "scalaz-core" % scalazVersion,
	"org.scalatest" %% "scalatest"   % "3.0.1"  % "test"
)

cancelable in Global := true
