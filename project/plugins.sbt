libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.4.8"

addSbtPlugin("ch.epfl.scala"             % "sbt-scalafix" % "0.11.0")
addSbtPlugin("com.github.sbt"            % "sbt-git"      % "2.0.1")
addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.4.4")
addSbtPlugin("org.scalameta"             % "sbt-scalafmt" % "2.5.0")
addSbtPlugin("pl.project13.scala"                % "sbt-jmh"                   % "0.4.5")

addDependencyTreePlugin
