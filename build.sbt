name := """play-scala-starter-example"""

version := "0.0.1-SNAPSHOT"

val buildVersion = "0.12.4-fix26"

resolvers += "Sonatype Staging" at "https://oss.sonatype.org/content/repositories/staging/"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  guice,
  "com.typesafe.play" %% "play-iteratees" % "2.6.1",
  "org.reactivemongo" %% "play2-reactivemongo" % buildVersion
)

routesGenerator := InjectedRoutesGenerator

fork in run := true

lazy val root = (project in file(".")).enablePlugins(PlayScala)
