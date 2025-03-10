package CombiningMultipleCompletableFutures;

import java.util.concurrent.CompletableFuture;

public class ThenCombineDemo {
    public static void main(String[] args) {
        CompletableFuture<Integer>future1=CompletableFuture.supplyAsync(()->{
            System.out.println("Data From API One ");
            return 100;
        });

        CompletableFuture<Integer>future2=CompletableFuture.supplyAsync(()->{
            System.out.println("Data From API Two");
            return 20;
        });

        CompletableFuture<Integer>FinalResult=future1.thenCombine(future2,(price1,price2)->{
            System.out.println("The Final Output Is:");
            return price1-price2;
        });

        FinalResult.thenAccept(System.out::println);
    }
}
