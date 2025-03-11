package CombiningMultipleCompletableFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompleteonTimeoutMethod {
    public static void main(String[] args) {

        CompletableFuture<Integer>Future1=CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 100;
        });

        /*
        /The 404 value is the fall back value
         */
        Future1.completeOnTimeout(404,2,TimeUnit.SECONDS );

        System.out.println(Future1.join());

        Future1.thenAccept(System.out::println);
    }
}
