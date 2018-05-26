package vkorchik

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import vkorchik.Data._
import vkorchik.converter.{Converter, JavaConverter, ScalaConverter}
import vkorchik.model.Enormous

@State(Scope.Benchmark)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1, jvmArgs = Array("-Xmx2G"))
@Threads(2)
@Measurement(iterations = 10, time = 10, timeUnit = TimeUnit.SECONDS)
@Warmup(iterations = 10, time = 10, timeUnit = TimeUnit.SECONDS)
abstract class BenchmarkBase(converter: Converter) {

  @Benchmark
  def serialization_with_creation: Array[Byte] = {
    converter.toByteArray(enormous)
  }

  val bytes = ScalaConverter.toByteArray(enormous)

  @Benchmark
  def deserialization: Enormous = {
    converter.parseFrom(bytes)
  }
}

class ScalaPbBenchmark extends BenchmarkBase(ScalaConverter) {

  val scalaEnormousPB = ScalaConverter.enormousToPb(enormous)

  @Benchmark
  def serialization_without_creation: Array[Byte] = {
    scalaEnormousPB.toByteArray
  }
}

class JavaPbBenchmark extends BenchmarkBase(JavaConverter) {

  val javaEnormousPB = JavaConverter.enormousToPb(enormous)

  @Benchmark
  def serialization_without_creation: Array[Byte] = {
    javaEnormousPB.toByteArray
  }
}
