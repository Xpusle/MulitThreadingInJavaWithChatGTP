import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {
    int array[];
    int start, end;
    private final int THRESHOLD = 2;

    SumTask(int array[], int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public  Integer compute() {
        int sum = 0;
        if (end - start <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask rightsidetask = new SumTask(array, start, end);
            SumTask leftsideTask = new SumTask(array, start, mid);

            rightsidetask.fork();
            int rigthresult = rightsidetask.compute();
            int leftsideresult = leftsideTask.join();

            return leftsideresult + rigthresult;
        }

    }

}

class maindemo {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SumTask task = new SumTask(array, 0, array.length);

        ForkJoinPool pool = new ForkJoinPool();

        int sum = pool.invoke(task);
        System.out.println(sum);
    }
}
