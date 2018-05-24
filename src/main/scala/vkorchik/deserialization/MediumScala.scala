package vkorchik.deserialization

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import vkorchik.Data

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class MediumScala {

  val bytes = Data.Scala.medium.toByteArray

  @Benchmark
  def test: vkorchik.protos.Medium = vkorchik.protos.Medium.parseFrom(bytes)

}
