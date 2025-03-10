import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {


//        List<Integer> list= IntStream.range(1,10_000_00).boxed().toList();
//
//        long starttine=System.currentTimeMillis();
//        long sum=list.parallelStream().mapToInt(Integer::intValue).sum();
//        long endtime=System.currentTimeMillis();
//        System.out.println(endtime-starttine+" ms "+"Sum :"+sum);

//        CompletableFuture<Void> future = CompletableFuture.runAsync(() ->
//                System.out.println("Hi This a Asynchronous Function ")
//        );

        //System.out.println(Thread.currentThread().getName());
        CompletableFuture<String> future1=CompletableFuture.supplyAsync(()->{
            return "Siddarth";
        }).thenCompose(fullname->fetchUser("siddarth"));

        System.out.println(future1.join());
    }
    static CompletableFuture<String>fetchUser(String username){
        return CompletableFuture.supplyAsync(()->username+"Kanamadi");
    }
}
