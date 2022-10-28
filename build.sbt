val scala3Version = "3.2.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "hello-jgit",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
    libraryDependencies += "org.eclipse.jgit" % "org.eclipse.jgit" % "6.3.0.202209071007-r"
  )
