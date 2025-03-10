package ParallelStreams;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void main(String[] args) {

        List<Integer> numbers = IntStream.range(1, 10_000_000).boxed().toList();
        System.out.println("Sequential streaming ");
        long starttime = System.currentTimeMillis();
//        IntStream.range(1,10).forEach(i-> System.out.println(i+" "+Thread.currentThread().getName()));
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        long endtime = System.currentTimeMillis();
        System.out.println("The Time Took By Sequential is : " + (endtime - starttime) + "ms  And The Sum is " + sum);


        System.out.println("Parallel Streaming ");
        long starttimefoparllel = System.currentTimeMillis();
//        IntStream.range(1,10).parallel().forEach(i-> System.out.println(i+""+Thread.currentThread().getName()));
        int sum2 = numbers.parallelStream().mapToInt(Integer::intValue).sum();
        long endtimeofparllel = System.currentTimeMillis();
        System.out.println("The Time by Parllel is :" + (endtimeofparllel - starttimefoparllel) + "ms And The sum is " + sum2);
    }
}
