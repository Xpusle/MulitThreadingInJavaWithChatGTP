package allofandanyofmethods;

import java.util.concurrent.CompletableFuture;

public class AnyofMethodDemo {
    public static void main(String[] args) {

        CompletableFuture<String> t1 = CompletableFuture.supplyAsync(() ->
                "Task1"
        );

        CompletableFuture<String> t2 = CompletableFuture.supplyAsync(() ->
                "Task2"
        );

        CompletableFuture<Object> anyoftask = CompletableFuture.anyOf(t1, t2);
        anyoftask.thenAccept(result -> System.out.println("First Task " + result));

    }
}
