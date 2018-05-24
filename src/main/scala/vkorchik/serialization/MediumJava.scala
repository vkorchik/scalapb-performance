package vkorchik.serialization

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import vkorchik.Data

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class MediumJava {

  @Benchmark
  @OperationsPerInvocation(100)
  def test: Array[Byte] =
    (0 to 100) map (_ => Data.Java.medium.toByteArray) head
}
