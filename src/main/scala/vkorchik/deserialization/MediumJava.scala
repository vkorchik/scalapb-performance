package vkorchik.deserialization

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import vkorchik.Data
import vkorchik.Protos.Medium

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class MediumJava {

  val bytes = Data.Java.medium.toByteArray

  @Benchmark
  def test: Medium = Medium.parseFrom(bytes)
}
