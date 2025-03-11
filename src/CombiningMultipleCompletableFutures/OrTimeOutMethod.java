package CombiningMultipleCompletableFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class OrTimeOutMethod {
    public static void main(String[] args) {

        CompletableFuture<Integer>Future1=CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("This Future 1 ");
            return 100;
        });

        Future1.orTimeout(4, TimeUnit.SECONDS);

        Future1.join();
    }
}
