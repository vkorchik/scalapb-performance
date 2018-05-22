package vkorchik

import java.util.concurrent.TimeUnit

import protos.SmallOuterClass.Small

import org.openjdk.jmh.annotations._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class JS {

  val small = Small.newBuilder().setId(123).buildPartial()

  @Benchmark
  def test: Array[Byte] = small.toByteArray
}
