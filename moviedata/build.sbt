
name := "moviedata"

scalaVersion := "2.12.10"

version := "0.1"



libraryDependencies += "org.apache.spark" %% "spark-mllib" % "3.2.1"// % "provided"
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.2.1"// % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.2.1" //% "runtime"

Compile / doc / scalacOptions ++= Seq("-Vimplicits", "-deprecation", "-Ywarn-dead-code", "-Ywarn-value-discard", "-Ywarn-unused")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % "test"