package idv.kuma.parallelstream;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Parallels {

    public static void main(String[] args) {
        System.out.println("parallel: " + measureSumPerformance(Parallels::parallelSum, 10_000_000L));
        System.out.println("sequential: " + measureSumPerformance(Parallels::sequentialSum, 10_000_000L));
        System.out.println("for-loop: " + measureSumPerformance(Parallels::iterativeSum, 10_000_000L));
        System.out.println("LongRange: " + measureSumPerformance(Parallels::rangedSum, 10_000_000L));
        System.out.println("LongRangeParallel: " + measureSumPerformance(Parallels::parallelRangedSum, 10_000_000L));
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0L;
        for (int i = 0; i < n; i++) {
            result += 1;
        }
        return result;
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }


    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long measureSumPerformance(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;

        for (int i = 0; i < 100; i++) {

            long start = System.nanoTime();
            long sum = adder.apply(n);

            long duration = (System.nanoTime() - start) / 1_000_000;

            if (duration < fastest) fastest = duration;

        }

        return fastest;
    }
}
