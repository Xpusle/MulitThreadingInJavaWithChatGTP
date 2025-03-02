package ThreadCommuication;

public class SharedData {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException ignored) {

            }
        }
        data = value;
        available = true;
        System.out.println("Producer Produced :" + data);
        notify();
    }

    public synchronized void conusme() {
        while (!available) {//If the available is false "!" NOT Opertaor
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        System.out.println("Consumer Consumed :" + data);
        available = false;
        notify();
    }

    static class Producer implements Runnable {
        private final SharedData shareddata;

        public Producer(SharedData shareddata) {
            this.shareddata = shareddata;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                shareddata.produce(i);
            }
        }
    }

    static class Conumse implements Runnable {
        private final SharedData shareddata;

        Conumse(SharedData shareddata) {
            this.shareddata = shareddata;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                shareddata.conusme();
            }
        }
    }

}

class ThreadCommuicationExample {
    public static void main(String[] args) {
        SharedData shared = new SharedData();
        Thread Pt1 = new Thread(new SharedData.Producer(shared));
        Thread Ct2 = new Thread(new SharedData.Conumse(shared));

        Pt1.start();
        Ct2.start();

    }
}
