package vkorchik.deserialization

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import vkorchik.Data

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class HugeScala {

  val bytes = Data.Scala.huge.toByteArray

  @Benchmark
  def test: vkorchik.protos.Huge = vkorchik.protos.Huge.parseFrom(bytes)

}
