package vkorchik.deserialization

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import vkorchik.Data

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class BigScala {

  val bytes = Data.Scala.big.toByteArray

  @Benchmark
  def test: vkorchik.protos.Big = vkorchik.protos.Big.parseFrom(bytes)

}
