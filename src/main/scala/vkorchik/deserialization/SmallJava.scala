package vkorchik.deserialization

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import vkorchik.Data
import vkorchik.Protos.Small

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class SmallJava {

  val bytes = Data.Java.small.toByteArray

  @Benchmark
  def test: Small = Small.parseFrom(bytes)
}
