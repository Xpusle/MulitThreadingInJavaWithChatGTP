package CombiningMultipleCompletableFutures;

import java.util.concurrent.CompletableFuture;

public class AcceptEither {
    public static void main(String[] args) {

        CompletableFuture<Integer> Future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 100;
        });

        CompletableFuture<Integer> Future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 200;
        });

        Future1.acceptEither(Future2, (value) -> {
            System.out.println(value + 100);
        });

        System.out.println(Future1.join());
    }
}
