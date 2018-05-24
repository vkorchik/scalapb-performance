package vkorchik.deserialization

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import vkorchik.Data
import vkorchik.Protos.Enormous

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class EnormousJava {

  val bytes = Data.Java.enormous.toByteArray

  @Benchmark
  def test: Enormous = Enormous.parseFrom(bytes)
}
