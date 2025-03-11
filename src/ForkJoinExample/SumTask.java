package ForkJoinExample;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {
    int array[];
    int start, end;
    private static final int THRSHOLD = 10;

    SumTask(int array[], int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (start - end <= THRSHOLD) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask leftsideofthearray = new SumTask(array, start, mid);
            SumTask Rightsideofthearray = new SumTask(array, mid, end);

            leftsideofthearray.fork();

            int rightside = Rightsideofthearray.compute();
            int leftside = leftsideofthearray.join();

            return leftside + rightside;
        }

    }

}

class main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(arr, 0, arr.length);

        int sum = pool.invoke(task);
        System.out.println("Sum :" + sum);
    }
}
