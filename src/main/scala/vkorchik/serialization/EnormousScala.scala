package vkorchik.serialization

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import vkorchik.Data

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class EnormousScala {

  @Benchmark
  @OperationsPerInvocation(100)
  def test: Array[Byte] =
    (0 to 100) map (_ => Data.Scala.enormous.toByteArray) head
}
