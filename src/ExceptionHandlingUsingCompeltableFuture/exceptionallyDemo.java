package ExceptionHandlingUsingCompeltableFuture;

import java.util.concurrent.CompletableFuture;

public class exceptionallyDemo {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Performing Some Task");
            if (true)
                throw new RuntimeException("Somthing Is Not Quite Right");
            return 10;

        }).exceptionally(ex -> {
            System.out.println("Exception :" + ex.getMessage());
            return 0;
        });

        System.out.println(future.join());

    }
}
