package java8_stream;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by xianpeng.xia
 * on 2019-04-02 23:34
 */
public class ParallelStreamDemo {

    public static void main(String[] args) {
        long sum = parallelSum(200);
        System.out.println("sum = " + sum);
        System.out.println(measureSumPerf(ParallelStreamDemo::iteraativeSum, 10000000));
        System.out.println(measureSumPerf(ParallelStreamDemo::sequentialSum, 10000000));
        System.out.println(measureSumPerf(ParallelStreamDemo::parallelSum, 10000000));
        System.out.println(measureSumPerf(ParallelStreamDemo::rangedSum, 10000000));
        System.out.println(measureSumPerf(ParallelStreamDemo::parallelRangeSum,10000000));
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1L)
            .limit(n)
            .reduce(0L, Long::sum);
    }

    public static long iteraativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
            .limit(n)
            .parallel()
            .reduce(0L, Long::sum);
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
            .reduce(0L, Long::sum);
    }

    public static long parallelRangeSum(long n) {
        return LongStream.rangeClosed(1,n)
            .parallel()
            .reduce(0L,Long::sum);
    }

    public static long measureSumPerf(Function<Long, Long> addr, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = addr.apply(n);
            long duration = (System.nanoTime() - start) / 1000000;
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }
}
