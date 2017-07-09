name := """play-scala-starter-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0" % Test,
  "com.h2database" % "h2" % "1.4.194"
)

libraryDependencies += (("org.reactivemongo" % "play2-reactivemongo_2.11" % "0.12.5-play26")
  .exclude("com.typesafe.akka","akka-actor_2.11")
  .exclude("org.scala-lang.modules","scala-xml_2.11")
  .exclude("org.typelevel","macro-compat_2.11"))

