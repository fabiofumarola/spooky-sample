name := "spark-sample"

version := "1.0"

scalaVersion := "2.10.5"

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.10" % "1.5.2",
  "org.apache.spark" % "spark-sql_2.10" % "1.5.2",
  "org.apache.httpcomponents" % "httpclient" % "4.5.1",
  "com.tribbloids.spookystuff" % "spookystuff-core" % "0.3.2"
)
    