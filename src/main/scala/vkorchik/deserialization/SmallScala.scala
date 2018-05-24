package vkorchik.deserialization

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import vkorchik.Data

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class SmallScala {

  val bytes = Data.Scala.small.toByteArray

  @Benchmark
  def test: vkorchik.protos.Small = vkorchik.protos.Small.parseFrom(bytes)

}
