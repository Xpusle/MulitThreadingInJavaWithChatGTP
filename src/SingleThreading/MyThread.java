package SingleThreading;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("This is Thread one :" + 1 + " Id " + Thread.currentThread().getId());
        System.out.println("This is Thread Two :" + 2 + " Id " + Thread.currentThread().getId());

    }

}

class main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        MyThread thread1 = new MyThread();
        thread.start();
        System.out.println("State of The thread object " + thread.getState());
        thread1.start();

    }
}
