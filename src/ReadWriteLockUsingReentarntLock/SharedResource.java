package ReadWriteLockUsingReentarntLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {
    int data=0;
    ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

    public void readdata(){
        lock.readLock().lock();
            try{
                System.out.println(Thread.currentThread().getName()+"This Thread is Reading  "+data);
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println("Thread is Interrupted");
            }finally {
                lock.readLock().unlock();
            }

    }

    public void writedata(int value){
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"This is Writing ");
            Thread.sleep(1000);
            data=value;
            System.out.println(Thread.currentThread().getName()+"This Thread Updated The Data "+data);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }
}

class main{
    public static void main(String[] args) {

        SharedResource sr=new SharedResource();

        Runnable readtask=sr::readdata;
        new Thread(readtask,"reader 1").start();
        new Thread(readtask,"reader 2").start();
        new Thread(readtask,"reader 3").start();

        Runnable writeTask=()-> sr.writedata(100);
        new Thread(writeTask,"writer 1").start();

    }
}