package ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task implements Runnable {

    int taskid;

    public Task(int taskid) {
        this.taskid = taskid;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is executing " + taskid);
    }
}

class main {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        ExecutorService exe1=Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            exe.execute(new Task(i));
        }

        for(int i=0;i<5;i++){
            exe1.execute(new Task(i));
        }
        exe.shutdown();

        exe1.shutdown();
    }
}
