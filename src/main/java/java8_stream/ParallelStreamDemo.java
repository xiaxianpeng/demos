package java8_stream;

import java.util.stream.Stream;

/**
 * Created by xianpeng.xia
 * on 2019-04-02 23:34
 */
public class ParallelStreamDemo {

    public static void main(String[] args) {
        long sum = parallelSum(200);
        System.out.println("sum = " + sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
            .limit(n)
            .parallel()
            .reduce(0L, Long::sum);
    }
}
