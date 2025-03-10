package allofandanyofmethods;

import java.util.concurrent.CompletableFuture;

public class allofmethoddemo {
    public static void main(String[] args) {

//        CompletableFuture<Void>t1=CompletableFuture.supplyAsync(()->(
//           "This is t1")
//        ).thenApply()

        CompletableFuture<Void>t2=CompletableFuture.runAsync(()->{
            System.out.println("This is t2");
        });

        //CompletableFuture<Void> AllTasks=CompletableFuture.allOf(t1,t2);

        //AllTasks.join();
    }
}
