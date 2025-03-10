package CombiningMultipleCompletableFutures;

import java.util.concurrent.CompletableFuture;

public class runAfterEither {
    public static void main(String[] args) {

        CompletableFuture<Void> Future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("This Is FirstTask");
            return null;
        });

        CompletableFuture<Void> Future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("This Is SecondTask");
            return null;
        });

        Future1.runAfterEither(Future2, () -> {
            System.out.println("This Prints After Any Task Is Completed");
        });

        System.out.println(Future1.join());
    }
}
