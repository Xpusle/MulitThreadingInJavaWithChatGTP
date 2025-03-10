import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Task extends RecursiveTask<Integer> {

    int array[];
    int start, end;
    private final static int THRESSHOLD = 3;

    Task(int array[], int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (start - end <= THRESSHOLD) {
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            Task rightarray = new Task(array, start, end);
            Task leftarray = new Task(array, start, mid);

            rightarray.fork();
            int righttask = rightarray.compute();
            int lefttask = leftarray.join();

            return righttask + lefttask;
        }
    }
}

class main {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Task demo = new Task(array, 0, array.length);

        ForkJoinPool pool=new ForkJoinPool();

        int sum=pool.invoke(demo);
        System.out.println(sum);

        System.out.println(pool);

    }
}