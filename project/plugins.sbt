resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.0")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")
