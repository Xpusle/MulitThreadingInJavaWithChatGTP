package Exercise;

public class MyThread extends Thread{

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println( i);
        }
    }
}


class main {
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();

    }
}
