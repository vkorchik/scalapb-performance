package vkorchik.deserialization

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import vkorchik.Data

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class EnormousScala {

  val bytes = Data.Scala.enormous.toByteArray

  @Benchmark
  def test: vkorchik.protos.Enormous = vkorchik.protos.Enormous.parseFrom(bytes)

}
