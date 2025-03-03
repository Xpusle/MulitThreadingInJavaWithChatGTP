package ReentrantLockDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Task {

    private final ReentrantLock lock = new ReentrantLock();

    public void demo() {
        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName()+"Locked ");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()+"Released");
                }
            }else{
                System.out.println(Thread.currentThread().getName()+"Lock couldn't Be acquired");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class trylockdemo{
    public static void main(String[] args) {
        Task task=new Task();

        Thread t1=new Thread(task::demo,"Thread 1");
        Thread t2=new Thread(task::demo,"Thread 2");

        t1.start();
        t2.start();
    }
}
