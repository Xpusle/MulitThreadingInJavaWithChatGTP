package ThreadLocal;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<Integer> tl=ThreadLocal.withInitial(()->1);

        Runnable task=()->{
            tl.set(tl.get()+1);
            System.out.println(Thread.currentThread().getName()+"The value of The Thread is : "+tl.get());
        };

        new Thread(task,"t1").start();
        new Thread(task,"t2").start();
        new Thread(task,"t3").start();

    }
}
