package DeadLock;

public class Resources {
    String name;

    public Resources(String name) {
        this.name = name;
    }


}

class DeadLockExample implements Runnable {
    private final Resources r1;
    private final Resources r2;

    public DeadLockExample(Resources r1, Resources r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void run() {
        synchronized (r1) {
            System.out.println(Thread.currentThread().getName() + " Locked " + r1.name);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (r2) {
            System.out.println(Thread.currentThread().getName() + " Locked " + r2.name);
        }
    }

    public static void main(String[] args) {
        Resources Resource1 = new Resources("Resource 1");
        Resources Resource2 = new Resources("Resource 2");

        //DeadLock Class
        Thread t1=new Thread(new DeadLockExample(Resource1,Resource2),"Thread1");
        Thread t2=new Thread(new DeadLockExample(Resource1,Resource2),"Thread2");

        t1.start();
        t2.start();
    }
}
