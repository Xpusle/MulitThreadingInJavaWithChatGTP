package CombiningMultipleCompletableFutures;

import java.util.concurrent.CompletableFuture;

public class ApplyToEitherDemo {
    public static void main(String[] args) {
        CompletableFuture<Integer> Future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("This is Future 1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 100;
        });

        CompletableFuture<Integer> Future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("This is Future 2");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 50;
        });

        CompletableFuture<Integer> FinalResult = Future1.applyToEither(Future2, (value) -> {
            System.out.println("The Final Result is ");
            return value * 2;
        });

        System.out.println(FinalResult.join());
    }
}
