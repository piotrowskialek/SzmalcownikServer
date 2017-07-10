name := """play-scala-starter-example"""
//
//version := "1.0-SNAPSHOT"
//
//lazy val root = (project in file(".")).enablePlugins(PlayScala)
//
//resolvers += Resolver.sonatypeRepo("snapshots")
//
//scalaVersion := "2.12.2"
//
//libraryDependencies ++= Seq(
//  guice,
//  "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0" % Test,
//  "com.h2database" % "h2" % "1.4.194"
//)
//
//libraryDependencies += (("org.reactivemongo" % "play2-reactivemongo_2.11" % "0.12.5-play26")
//  .exclude("com.typesafe.akka","akka-actor_2.11")
//  .exclude("org.scala-lang.modules","scala-xml_2.11")
//  .exclude("org.typelevel","macro-compat_2.11"))
//
//name := "reactivemongo-demo-app"

val buildVersion = "0.12.4-fix26"

version := "0.0.1-SNAPSHOT"

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
