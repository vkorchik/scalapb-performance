package vkorchik.deserialization

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import vkorchik.Data
import vkorchik.Protos.Huge

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class HugeJava {

  val bytes = Data.Java.huge.toByteArray

  @Benchmark
  def test: Huge = Huge.parseFrom(bytes)
}
