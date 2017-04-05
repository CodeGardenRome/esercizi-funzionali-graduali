name := "incremental-katas-jvm-langs"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.1"

val javaslangVersion = "2.0.5"
val scalazVersion = "7.2.10"


libraryDependencies ++= Seq(
	"io.javaslang"   % "javaslang"   % javaslangVersion,
	"org.scalaz"    %% "scalaz-core" % scalazVersion,
	"junit"          % "junit"       % "4.12"   % "test",
	"org.scalatest" %% "scalatest"   % "3.0.1"  % "test"
)