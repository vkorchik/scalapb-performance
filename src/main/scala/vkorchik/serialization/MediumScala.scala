package vkorchik.serialization

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import vkorchik.Data

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class MediumScala {

  @Benchmark
  def test: Array[Byte] = Data.Scala.medium.toByteArray
}
