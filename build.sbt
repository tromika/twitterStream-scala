name:="twitter-scala"

scalaVersion := "2.10.2"

version:="0.1"

libraryDependencies += "org.twitter4j" % "twitter4j-core" % "4.0.1"

libraryDependencies += "org.twitter4j" % "twitter4j-stream" % "4.0.1"

resolvers += "spray" at "http://repo.spray.io/"

libraryDependencies += "io.spray" %%  "spray-json" % "1.2.6"



