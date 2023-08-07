Matrix Convolve Benchmarks
==========================

[SBT]: https://www.scala-sbt.org/

To run, please install Java 17, [SBT] and then execute

```console
$> sbt Jmh/run
[info] welcome to sbt 1.9.3 (Homebrew Java 17.0.7)
[info] loading settings for project global-plugins from plugins.sbt ...
...
```

Latest results
--------------

Run at MacPro'19, 2,3 GHz 8-Core Intel Core i9, 16 GB 2400 MHz DDR4

VM version: JDK 17.0.7, OpenJDK 64-Bit Server VM, 17.0.7+0

JMH version: 1.36

| Benchmark         | (height) | (width) | Mode |  Cnt |  Score ± Error | Units |
| :---------------- | -------: | :------ | ---: | ---: | -------------: | :---- |
| convolveLogical   |     1024 | 1024    | avgt |   10 | 10.092 ± 0.313 | ms/op |
| convolveNaive     |     1024 | 1024    | avgt |   10 |  3.664 ± 0.379 | ms/op |
| convolveSegmented |     1024 | 1024    | avgt |   10 |  2.900 ± 0.179 | ms/op |


Full JMH output
---------------

```console
running (fork) org.openjdk.jmh.Main
# JMH version: 1.36
# VM version: JDK 17.0.7, OpenJDK 64-Bit Server VM, 17.0.7+0
# VM invoker: /usr/local/Cellar/openjdk@17/17.0.7/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 5 s each
# Measurement: 10 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: convolve.Benchmarks.convolveLogical
# Parameters: (height = 1024, width = 1024)
# Run progress: 0.00% complete, ETA 00:03:45
# Fork: 1 of 1
# Warmup Iteration   1: 10.132 ms/op
# Warmup Iteration   2: 10.019 ms/op
# Warmup Iteration   3: 9.845 ms/op
# Warmup Iteration   4: 9.936 ms/op
# Warmup Iteration   5: 9.941 ms/op
Iteration   1: 9.915 ms/op
Iteration   2: 10.022 ms/op
Iteration   3: 9.933 ms/op
Iteration   4: 10.001 ms/op
Iteration   5: 10.457 ms/op
Iteration   6: 10.205 ms/op
Iteration   7: 10.417 ms/op
Iteration   8: 9.953 ms/op
Iteration   9: 10.133 ms/op
Iteration  10: 9.882 ms/op
Result "convolve.Benchmarks.convolveLogical":
  10.092 ±(99.9%) 0.313 ms/op [Average]
  (min, avg, max) = (9.882, 10.092, 10.457), stdev = 0.207
  CI (99.9%): [9.778, 10.405] (assumes normal distribution)
# JMH version: 1.36
# VM version: JDK 17.0.7, OpenJDK 64-Bit Server VM, 17.0.7+0
# VM invoker: /usr/local/Cellar/openjdk@17/17.0.7/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 5 s each
# Measurement: 10 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: convolve.Benchmarks.convolveNaive
# Parameters: (height = 1024, width = 1024)
# Run progress: 33.33% complete, ETA 00:02:31
# Fork: 1 of 1
# Warmup Iteration   1: 5.339 ms/op
# Warmup Iteration   2: 5.278 ms/op
# Warmup Iteration   3: 5.245 ms/op
# Warmup Iteration   4: 5.188 ms/op
# Warmup Iteration   5: 5.166 ms/op
Iteration   1: 4.345 ms/op
Iteration   2: 3.443 ms/op
Iteration   3: 3.578 ms/op
Iteration   4: 3.699 ms/op
Iteration   5: 3.657 ms/op
Iteration   6: 3.669 ms/op
Iteration   7: 3.571 ms/op
Iteration   8: 3.554 ms/op
Iteration   9: 3.590 ms/op
Iteration  10: 3.533 ms/op
Result "convolve.Benchmarks.convolveNaive":
  3.664 ±(99.9%) 0.379 ms/op [Average]
  (min, avg, max) = (3.443, 3.664, 4.345), stdev = 0.250
  CI (99.9%): [3.285, 4.043] (assumes normal distribution)
# JMH version: 1.36
# VM version: JDK 17.0.7, OpenJDK 64-Bit Server VM, 17.0.7+0
# VM invoker: /usr/local/Cellar/openjdk@17/17.0.7/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 5 s each
# Measurement: 10 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: convolve.Benchmarks.convolveSegmented
# Parameters: (height = 1024, width = 1024)
# Run progress: 66.67% complete, ETA 00:01:15
# Fork: 1 of 1
# Warmup Iteration   1: 2.651 ms/op
# Warmup Iteration   2: 2.526 ms/op
# Warmup Iteration   3: 2.600 ms/op
# Warmup Iteration   4: 2.846 ms/op
# Warmup Iteration   5: 2.840 ms/op
Iteration   1: 2.834 ms/op
Iteration   2: 3.211 ms/op
Iteration   3: 2.957 ms/op
Iteration   4: 2.801 ms/op
Iteration   5: 2.848 ms/op
Iteration   6: 2.903 ms/op
Iteration   7: 2.862 ms/op
Iteration   8: 2.831 ms/op
Iteration   9: 2.853 ms/op
Iteration  10: 2.904 ms/op
Result "convolve.Benchmarks.convolveSegmented":
  2.900 ±(99.9%) 0.179 ms/op [Average]
  (min, avg, max) = (2.801, 2.900, 3.211), stdev = 0.118
  CI (99.9%): [2.722, 3.079] (assumes normal distribution)
# Run complete. Total time: 00:03:46
REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.
NOTE: Current JVM experimentally supports Compiler Blackholes, and they are in use. Please exercise
extra caution when trusting the results, look into the generated code to check the benchmark still
works, and factor in a small probability of new VM bugs. Additionally, while comparisons between
different JVMs are already problematic, the performance difference caused by different Blackhole
modes can be very significant. Please make sure you use the consistent Blackhole mode for comparisons.
Benchmark                     (height)  (width)  Mode  Cnt   Score   Error  Units
Benchmarks.convolveLogical        1024     1024  avgt   10  10.092 ± 0.313  ms/op
Benchmarks.convolveNaive          1024     1024  avgt   10   3.664 ± 0.379  ms/op
Benchmarks.convolveSegmented      1024     1024  avgt   10   2.900 ± 0.179  ms/op
```
