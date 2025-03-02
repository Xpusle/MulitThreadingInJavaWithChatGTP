package ReentrantLockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {
    private final Lock lock1=new ReentrantLock();
    private final Lock lock2=new ReentrantLock();

    public void process(){
        while(true){
            if (lock1.tryLock()){
                try{
                    if (lock2.tryLock()){
                        try{
                            System.out.println(Thread.currentThread().getName()+"Both The resources Are Locked");
                            return;
                        }finally {
                            lock2.unlock();
                        }
                    }
                }finally {
                    lock1.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        TryLockExample example=new TryLockExample();

        Thread t1=new Thread(example::process,"Thread 1");
        Thread t2=new Thread(example::process,"Thread 2");

        t1.start();
        t2.start();

    }
}
