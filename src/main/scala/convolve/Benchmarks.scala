package convolve

import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit
import scala.util.Random

@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 0)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 10, time = 5)
class Benchmarks:
  @Param(Array("1024"))
  private var height = 1

  @Param(Array("1024"))
  private var width = 1

  private var matrix: Matrix = _

  @Setup
  def setup(): Unit =
    val random = Random()
    val data   = new Array[Double](height * width)

    for
      i <- 0 until height
      j <- 0 until width
    do data(i * width + j) = random.nextDouble()

    matrix = Matrix(IArray.unsafeFromArray(data), height, width)
  end setup

  @Benchmark
  def convolveNaive(): Double = Convolve.naive(matrix)

  @Benchmark
  def convolveSegmented(): Double = Convolve.segmented(matrix)

  @Benchmark
  def convolveLogical(): Double = Convolve.logical(matrix)
end Benchmarks
