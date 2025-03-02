package SynchronizationandSaftey;

public class RaceCondition extends Thread {

    int count;
    private final Object lock=new Object();
    void increment() {
        synchronized (lock) {
            count++;
        }
    }
}

class main {
    public static void main(String[] args) {
        RaceCondition counter = new RaceCondition();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.count);
    }
}
