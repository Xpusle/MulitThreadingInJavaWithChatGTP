package ThreadSynchronization;

public class SynchronizationDemo {

    public synchronized  void Thread1(){
        System.out.println("Hello world This is Thread One : "+Thread.currentThread().getName()
        +" And I am synchronized method ");
    }

    public void Thread2(){
        synchronized (this){
            System.out.println("Hello World This is Thread Two :"+Thread.currentThread().getName()+" And I am synchronized block ");
        }
    }
}

class main{
    public static void main(String[] args) {
        SynchronizationDemo obj=new SynchronizationDemo();
        Thread t1=new Thread(()-> obj.Thread1());
        Thread t2=new Thread(()-> obj.Thread2());

        t1.start();
        t2.start();
    }
}
