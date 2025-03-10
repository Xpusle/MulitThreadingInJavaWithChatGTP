
import java.util.concurrent.CompletableFuture;

public class CompletableFunctionsinjava {
    public static void main(String[] args) {

        /**
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            if (true)
                throw  new RuntimeException("Somthing Not quite Right ");
            return 100;
        }).whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("The Exception Is Not Handled :" + ex.getMessage());
            } else {
                System.out.println("The Exception is Handled");
                System.out.println(result);
            }
        });
        future.join();

        **/
        /**
        CompletableFuture<Integer> futurehandel = CompletableFuture.supplyAsync(() -> {
            if (true)
                throw new RuntimeException("Something Not Correct There is problem   ");
            return 100;

        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("There is problem in The Function");
                return -1;
            }
            return result;

        });

        System.out.println(futurehandel.join());
         **/

        CompletableFuture<Integer>futureexpcetionally=CompletableFuture.supplyAsync(()->{
            if (true)
                throw new RuntimeException("There is a problem in the code ");
            return 100;
        }).exceptionally((ex)->{
            System.out.println("There is problem wait :"+ex.getMessage());
            return 0;
        });

        futureexpcetionally.thenAccept(System.out::println);
    }
}
