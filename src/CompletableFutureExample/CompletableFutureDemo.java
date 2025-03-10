package CompletableFutureExample;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {

        /*
        CompletableFuture<Void>future= CompletableFuture.runAsync(()->{
            System.out.println("This is a async task :"+Thread.currentThread().getName());
        });
        */
        /*
        CompletableFuture<String>future=CompletableFuture.supplyAsync(()->{
            return "Hello I am Async Function "+Thread.currentThread().getName();
        });
        System.out.println(future.join());
        */
        /*
        /First You Need To Create a Async Function Using supplyAsync Then Use thenApply
        /It  is Mainly Used To Perform a Operation  On a Result
         */
        /*
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->
                        "Siddarth")
                .thenApply(result -> result + "Kanamadi");

        System.out.println(future.join());

         */

        /*thenCompose Method
         */
        /*
        CompletableFuture<String>future=CompletableFuture.supplyAsync(()->{
            return "Siddarth ";
        }).thenCompose(greeting->fetchUser(greeting));

        future.thenAccept(System.out::println);

    }

    static CompletableFuture<String> fetchUser(String Username){
        return CompletableFuture.supplyAsync(()->Username +"HI");
    }
    */

        CompletableFuture<Integer>future1=CompletableFuture.supplyAsync(()->10);
        CompletableFuture<Integer>future2=CompletableFuture.supplyAsync(()->20);

        CompletableFuture<Integer>result=future1.thenCombine(future2,(r1,r2)->r1+r2);

        result.thenAccept(System.out::println);
    }
}
