package ExceptionHandlingUsingCompeltableFuture;

import java.util.concurrent.CompletableFuture;

public class HandelDemo {
    public static void main(String[] args) {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            if (true)
                throw new RuntimeException("Some Thing quite Not Right");
            return 100;
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("handled The Exception And Provided A FallBack Value ");
                return -1;
            }
            return result;
        });

        System.out.println(future.join());
    }
}
