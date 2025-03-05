package ScheduledThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

//        scheduler.schedule(() ->
//                        System.out.println(Thread.currentThread().getName() + "This Executes after given time ")
//                , 2, TimeUnit.SECONDS);
//
//
//        scheduler.scheduleAtFixedRate(() ->
//                        System.out.println("this is a example of FixedScheduleRate :" + Thread.currentThread().getName()),
//                2, 5, TimeUnit.SECONDS
//        );

        scheduler.scheduleWithFixedDelay(() ->
                System.out.println("This is example of of WithFixedDelay Method :"+Thread.currentThread().getName()),
                2,6,TimeUnit.SECONDS
        );
    }

}
