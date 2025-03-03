package ReentrantLockDemo;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

     ReentrantLock lock=new ReentrantLock();

     public void acessprocess(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class main{
    public static void main(String[] args) {

        SharedResource resource=new SharedResource();
        Thread t1=new Thread( resource::acessprocess);
        Thread t2=new Thread(resource::acessprocess);
        t1.start();
        t2.start();
    }
}
