ThisBuild / scalaVersion := "3.3.0"

ThisBuild / libraryDependencies ++= Seq(
  "org.openjdk.jmh" % "jmh-core" % "1.36",
  "org.openjdk.jmh" % "jmh-generator-annprocess" % "1.36",
)

enablePlugins(JmhPlugin)
