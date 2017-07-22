name := "incremental-katas-jvm-langs"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.1"

val vavrVersion = "0.9.0"
val scalazVersion = "7.2.10"


libraryDependencies ++= Seq(
	"io.vavr"        % "vavr"        % vavrVersion,
	"org.scalaz"    %% "scalaz-core" % scalazVersion,
	"junit"          % "junit"       % "4.12"   % "test",
	"org.scalatest" %% "scalatest"   % "3.0.1"  % "test"
)