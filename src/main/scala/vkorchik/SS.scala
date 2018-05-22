package vkorchik

import java.util.concurrent.TimeUnit

import protos.small.Small

import org.openjdk.jmh.annotations._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class SS {

  val small = Small(14)

  @Benchmark
  def test: Array[Byte] = small.toByteArray

}
