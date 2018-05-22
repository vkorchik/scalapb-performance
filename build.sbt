
name := "scalapb-performance"

version := "0.1"

scalaVersion := "2.12.6"

val protobufSettings = Compile / PB.targets := Seq(
  PB.gens.java -> (sourceManaged in Compile).value,
  scalapb.gen(javaConversions = true) -> (Compile / sourceManaged).value,
)

val root = (project in file("."))
  .enablePlugins(JmhPlugin)
  .settings(protobufSettings)
