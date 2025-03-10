package ExceptionHandlingUsingCompeltableFuture;

import java.util.concurrent.CompletableFuture;

public class WhenCompleteDemo {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            if (true)
                throw new RuntimeException("SomeThing Quite Not Right");
            return 50;
        }).whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("The Exception is Not Handled :" + ex.getMessage());
            }else{
                System.out.println("Success :"+result);
            }
        });

        future.join();
    }
}
