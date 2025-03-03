package StaticSynchronization;

public class Counter {

   static int count;

    public static synchronized void increment(){
        count++;
        System.out.println(Thread.currentThread().getName()+" count :"+count);
    }
}

class main{
    public static void main(String[] args) {
        Counter counterobj1=new Counter();
        Counter counterobj2=new Counter();
        Counter counterobj3=new Counter();
        Thread t1=new Thread(()-> counterobj1.increment());
        Thread t2=new Thread(()-> counterobj2.increment());
        Thread t3=new Thread(()-> counterobj3.increment());
        t1.start();
        t2.start();
        t3.start();
    }
}
