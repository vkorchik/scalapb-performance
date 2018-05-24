package vkorchik.deserialization

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import vkorchik.Data
import vkorchik.Protos.Big

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class BigJava {

  val bytes = Data.Java.big.toByteArray

  @Benchmark
  def test: Big = Big.parseFrom(bytes)
}
