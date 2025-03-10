package CombiningMultipleCompletableFutures;

import java.util.concurrent.CompletableFuture;

public class ThenAcceptBothDemo {
    public static void main(String[] args) {
        CompletableFuture<String> Future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("The Name of The Student is :");
            return "Ramesh";
        });

        CompletableFuture<String> Future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("The Age Of Student is :");
            return "32";
        });

        Future1.thenAcceptBoth(Future2, (name, age) -> {
            System.out.println("This is name & age of the student " + name + " " + age);
        });


    }
}
